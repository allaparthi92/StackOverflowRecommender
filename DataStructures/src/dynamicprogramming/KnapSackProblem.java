package dynamicprogramming;

public class KnapSackProblem {

	public static int knapScak(int w[],int v[],int weight){
		
		
		int[][] dp = new int[v.length+1][weight+1];
		
		
		for(int i=0;i<=v.length;i++){
			for(int j=0;j<=weight;j++){
				
				if(i==0 || j==0){
					dp[i][j] =0;
				}
				else if(w[i-1] <= j){
					dp[i][j] = Math.max(v[i-1]+ dp[i-1][j-w[i-1]],dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[v.length][weight];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   int val[] = {60, 100, 120};
		    int wt[] = {10, 20, 30};
		    int  W = 50;
		    
		    System.out.println(knapScak(wt,val,50));
	}

}
