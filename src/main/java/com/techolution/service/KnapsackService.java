package com.techolution.service;

import org.springframework.stereotype.Service;

@Service
public class KnapsackService {

	public int knapsack(int satisfactoryLimit[], int timeTakenForEachItem[], int totalTime) {
		int maxSatisfactoryLimit = 0;
		if (totalTime > 0) {
			int N = timeTakenForEachItem.length;

			int[][] V = new int[N + 1][totalTime + 1];
			for (int col = 0; col <= totalTime; col++) {
				V[0][col] = 0;
			}

			for (int row = 0; row <= N; row++) {
				V[row][0] = 0;
			}
			for (int item = 1; item <= N; item++) {

				for (int itemTime = 1; itemTime <= totalTime; itemTime++) {

					if (timeTakenForEachItem[item - 1] <= itemTime) {

						V[item][itemTime] = Math.max(
								satisfactoryLimit[item - 1] + V[item - 1][itemTime - timeTakenForEachItem[item - 1]],
								V[item - 1][itemTime]);
					} else {

						V[item][itemTime] = V[item - 1][itemTime];
					}
				}
			}
			maxSatisfactoryLimit = V[N][totalTime];
		}

		return maxSatisfactoryLimit;
	}

}
