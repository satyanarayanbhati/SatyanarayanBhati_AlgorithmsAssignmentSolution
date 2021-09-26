package com.greatlearning.assignment.service;

public class MergeSort {
	private double[] array;
	private boolean descOrder;

	public double[] getSortedArray(double[] array, boolean descOrder) {
		this.array = array;
		this.descOrder = descOrder;
		double[] temp = new double[array.length];
		mergeSort(this.array, temp, 0, this.array.length - 1);
		return this.array;
	}
    	
	private void mergeSort(double[] array, double[] temp, int myLeft,
			int myRight) {

		if (myLeft < myRight) {
			int center = (myLeft + myRight) / 2;
			mergeSort(array, temp, myLeft, center);
			mergeSort(array, temp, center + 1, myRight);
			merge(array, temp, myLeft, center + 1, myRight);
		}
	}

	private void merge(double[] array, double[] temp, int left, int myRight,
			int rightMost) {
		int leftEnd = myRight - 1;
		int k = left;
		int num = rightMost - left + 1;

		while (left <= leftEnd && myRight <= rightMost) {
			if (descOrder ? (array[left] > array[myRight])
					: (array[left] < array[myRight]))
				temp[k++] = array[left++];
			else
				temp[k++] = array[myRight++];
		}

		while (left <= leftEnd)
			temp[k++] = array[left++];

		while (myRight <= rightMost)
			temp[k++] = array[myRight++];

		for (int i = 0; i < num; i++, rightMost--)
			array[rightMost] = temp[rightMost];

	}

}
