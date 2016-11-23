package dynamicprogramming;

public class MinimumCostpath {

	public static void main(String[] args) {
		int cost[][] = { {1, 2, 3},{4, 8, 2}, {1, 5, 3} };
		MinimumCostpath(cost,3,3);
	}

	private static void MinimumCostpath(int[][] a, int m, int n) {
		int dp[][] = new int[3][3];
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(i==0 && j==0)
					dp[i][j] = a[i][j];
				else if(i==0 && j!=0)
					dp[i][j] = dp[i][j-1]+ a[i][j];
				else if(j==0 && i!=0)
					dp[i][j] = dp[i-1][j]+ a[i][j];
				else
					dp[i][j]= a[i][j] + min( dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
			}
		}
	
		System.out.println(dp[m-1][n-1]);
	}

	private static int min(int i, int j, int k) {
		if(i< j && j < k)
			return i;
		else if( j<k && k< i)
			return j;
		else 
			return k;
	}

}
