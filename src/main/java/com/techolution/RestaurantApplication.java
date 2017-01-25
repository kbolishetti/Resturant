package com.techolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.techolution.domain.Menu;

import com.techolution.service.FileProccesorService;
import com.techolution.service.KnapsackService;

@EnableAutoConfiguration
@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner {

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	FileProccesorService fileProcessor;

	@Autowired
	KnapsackService knapSackService;

	@Override
	public void run(String... args) {
		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new RuntimeException();
		}
		Resource resource = resourceLoader.getResource("classpath:data.txt");
		Menu menu = fileProcessor.prepareMenuFromResource(resource);
		System.out.println("value = " + knapSackService.knapsack(menu.getSatisfactoryLimit(),
				menu.getTimeTakenForEachItem(), menu.getMaximumAllowedTime()));
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
