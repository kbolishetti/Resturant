package com.techolution.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnapsackServiceTest {

	@Autowired
	@InjectMocks
	KnapsackService knapsackService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public final void testKnapsack_zeroValues() {
		assertEquals(0, knapsackService.knapsack(new int[] {}, new int[] {}, 0));

	}

	@Test
	public final void testKnapsack() {
		assertEquals(4, knapsackService.knapsack(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 9 }, 10));

	}
	
	@Test
	public final void testKnapsack_negativeValue() {
		assertEquals(0, knapsackService.knapsack(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 9 }, -1));

	}
	
	
}
