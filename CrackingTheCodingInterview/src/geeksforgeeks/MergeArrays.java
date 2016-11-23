package geeksforgeeks;

import java.util.Arrays;

public class MergeArrays {

	static void mergeArrays(Integer m[], Integer n[]) {

		int counter = m.length - 1;
		for (int i = m.length - 1; i >= 0; i--) {
			if (m[i] != -1) {
				m[counter--] = m[i];
			}
		}

		int temp = counter + 1;
		while (counter >= 0) {
			m[counter--] = -1;
		}

		int nC = 0;
		counter = 0;
		while (temp < m.length && nC < n.length) {
			if (m[temp] < n[nC]) {
				m[counter++] = m[temp++];
			} else {
				m[counter++] = n[nC++];
			}
		}

		while (nC < n.length) {
			m[counter++] = n[nC++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer m[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		Integer n[] = { 5, 7, 9, 25 };
		mergeArrays(m, n);

		System.out.println(Arrays.asList(m));
	}

}
