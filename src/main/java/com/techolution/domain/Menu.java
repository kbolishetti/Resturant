package com.techolution.domain;

public class Menu {

	private int maximumAllowedTime;
	private int totalItem;
	private int satisfactoryLimit[];
	private int timeTakenForEachItem[];


	public int getMaximumAllowedTime() {
		return maximumAllowedTime;
	}

	public void setMaximumAllowedTime(int maximumAllowedTime) {
		this.maximumAllowedTime = maximumAllowedTime;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int[] getSatisfactoryLimit() {
		return satisfactoryLimit;
	}

	public void setSatisfactoryLimit(int[] satisfactoryLimit) {
		this.satisfactoryLimit = satisfactoryLimit;
	}

	public int[] getTimeTakenForEachItem() {
		return timeTakenForEachItem;
	}

	public void setTimeTakenForEachItem(int[] timeTakenForEachItem) {
		this.timeTakenForEachItem = timeTakenForEachItem;
	}


}
