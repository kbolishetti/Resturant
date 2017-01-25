package com.techolution.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.techolution.domain.Menu;

@Component
public class FileProccesorService {

	private static final String REGEX = " ";

	public Menu prepareMenuFromResource(Resource file) {

		Menu menu = null;
		List<String> lines = new ArrayList<>();
		if (file != null && file.exists()) {
			try (BufferedReader br = Files.newBufferedReader(Paths.get(file.getURI()))) {
				lines = br.lines().collect(Collectors.toList());
				if (!lines.isEmpty()) {
					menu = prepareMenu(lines);
				}

			} catch (IOException ioe) {
				throw new RuntimeException(ioe.toString());
			}
		}
		return menu;

	}

	Menu prepareMenu(List<String> lines) {
		Menu menu = new Menu();
		if (!CollectionUtils.isEmpty(lines)) {
			setMaxAllowedTime(lines, menu);
			int[] satisfactoryLimit = new int[lines.size()];
			int[] timeTakenForEachItem = new int[lines.size()];
			populateMenuItems(lines, satisfactoryLimit, timeTakenForEachItem);
			menu.setSatisfactoryLimit(satisfactoryLimit);
			menu.setTimeTakenForEachItem(timeTakenForEachItem);
		}
		return menu;
	}

	private void populateMenuItems(List<String> lines, int[] satisfactoryLimit, int[] timeTakenForEachItem) {
		for (int i = 1; i < lines.size(); i++) {
			String[] dimensions = lines.get(i).split(REGEX);
			satisfactoryLimit[i - 1] = getIntFromString(dimensions[0]);
			timeTakenForEachItem[i - 1] = getIntFromString(dimensions[1]);
		}
	}

	private void setMaxAllowedTime(List<String> lines, Menu menu) {
		String[] dimension = lines.get(0).split(REGEX);
		menu.setMaximumAllowedTime(getIntFromString(dimension[0]));

	}

	int getIntFromString(String value) {
		int convertedValue = 0;
		if (StringUtils.isNotEmpty(value)) {
			try {
				convertedValue = Integer.parseInt(value);
			} catch (NumberFormatException nfe) {
				throw nfe;
			}
		}
		return convertedValue;
	}

}
