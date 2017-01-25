/**
 * 
 */
package com.techolution.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import com.techolution.domain.Menu;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileProccesorServiceTest {

	@Autowired
	@InjectMocks
	FileProccesorService fileProcessor;

	@Autowired
	ResourceLoader resourceLoader;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPrepareMenuFromResource_ResourceNull() {
		assertNull(fileProcessor.prepareMenuFromResource(null));

	}

	@Test
	public void testPrepareMenu() {
		java.util.List<String> lines = new ArrayList<>();
		lines.add("10000 100");
		lines.add("2023 12");
		Menu menu = fileProcessor.prepareMenu(lines);
		assertNotNull(menu);
		assertEquals(10000, menu.getMaximumAllowedTime());

	}

	@Test
	public void testgetIntFromString_Null() {
		assertEquals(0,fileProcessor.getIntFromString(null));

	}

	@Test(expected=NumberFormatException.class)
	public void testgetIntFromString_NaN() {
		assertEquals(0,fileProcessor.getIntFromString("@"));

	}

}
