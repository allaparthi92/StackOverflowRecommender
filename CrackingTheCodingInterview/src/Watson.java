import java.util.ArrayList;

public class Watson {

	static int a[] = { 2, 2, 2, 2, 3, 0, 3, 2, 2, 2 };
	static int b[][] = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 },
			{}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 2, 4 } };

	static int count(int curr, int n) {
		int sum = 0;
		if (n == 10) {
			return 1;
		} else {
			int i = 0;
			int val = 0;
			for (i = 0; i < a[curr]; i++) {
				val = count(b[curr][i], n + 1);
				sum += val;
			}
			return sum;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = count(1, 1);
		System.out.println(val);

	}

}
