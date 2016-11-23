package dynamicprogramming;

class  Bhanu {
	protected   void bhanu() {
		
		System.out.println("Interrface");
	}
}

class A extends Bhanu {
	public    void bhanu() {
		
		System.out.println("Class");
	}

}

public class NonAdjacentMaxSum {

	public static void maxNonAdjacentSum(int a[]) {
		int dp[] = new int[a.length];

		dp[0] = a[0];
		dp[1] = Math.max(dp[0], a[1]);

		for (int i = 2; i < a.length; i++) {
			dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 1]);

		}
		System.out.println(dp[a.length - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		maxNonAdjacentSum(a);
	}

}
