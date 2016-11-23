package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixzeros {

	public static void setMatrix(int a[][], int n) {
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> columns = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rows.contains(i) || columns.contains(j))
					a[i][j] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 1, 1 },
				{ 1, 1, 1, 1 } };
		setMatrix(a, 4);
	}

}
