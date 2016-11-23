package LinkedLists;

import java.util.HashMap;

public class TwoSumVariant {

	public static void twoSum(int a[], int b) {
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (hm.containsKey(a[i])) {
				hm.put(a[i], hm.get(a[i]) + 1);
			} else {
				hm.put(a[i], 1);
			}
		}

		for (int i = 0; i < a.length; i++) {

			if (hm.containsKey(b - a[i])) {

				int counter = hm.get(b - a[i]);

				for (int j = 0; j < counter; j++) {
					System.out.println(a[i] + "-------" + (b - a[i]));
					count++;
				}

				hm.remove(a[i]);
			}

		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 };
		twoSum(arr, 11);

	}

}
