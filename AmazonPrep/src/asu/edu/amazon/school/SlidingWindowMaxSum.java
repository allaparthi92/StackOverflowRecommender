package asu.edu.amazon.school;

import java.util.ArrayList;

public class SlidingWindowMaxSum {
	public static ArrayList<Integer> SlidingWindowSum(int a[], int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (a.length < 1) {
			return result;
		}
		int index = 0;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {

			if (count < k) {
				++count;
				sum = sum + a[i];

			} else {
				result.add(sum);
				sum = sum - a[index] + a[i];
				index++;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println(SlidingWindowSum(a, 3));
	}

}
