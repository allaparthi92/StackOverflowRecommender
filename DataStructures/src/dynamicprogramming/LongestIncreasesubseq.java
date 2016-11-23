package dynamicprogramming;

public class LongestIncreasesubseq {

	public static void main(String[] args) {
		 int a[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		// LIS(a);
		System.out.println(lis(a, a.length));
		
		System.out.println(LISA(a));

	}

	@SuppressWarnings("unused")
	private static int LISA(int[] a) {

		int dp[] = new int[a.length];

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		int max = dp[0];
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {

				if (a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					max = Math.max(dp[i], max);
				}
			}
		}

		return max;

	}

	static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			max = Math.max(max, lis[i]);
		}
		/* Pick maximum of all LIS values */

		return max;
	}

}
