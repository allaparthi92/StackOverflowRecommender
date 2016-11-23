package dynamicprogramming;

public class CoinChangeNoOfWays {
	
	public static int CoinChangeWays(int s[],int m, int n){
		
		if(n==0)
			return 1;
		
		if(n< 0){
			return 0;
		}
		
		if(m <=0 && n >=1){
			return 0;
		}
		
		return CoinChangeWays(s,m-1,n) + CoinChangeWays(s,m,n-s[m-1]);
		
	}
	
	int minCoins(int coins[], int m, int V)
	{
	    // table[i] will be storing the minimum number of coins
	    // required for i value.  So table[V] will have result
	    int table[] = new int[V+1];
	 
	    // Base case (If given value V is 0)
	    table[0] = 0;
	 
	    // Initialize all table values as Infinite
	    for (int i=1; i<=V; i++)
	        table[i] = Integer.MAX_VALUE;
	 
	    // Compute minimum coins required for all
	    // values from 1 to V
	    for (int i=1; i<=V; i++)
	    {
	        // Go through all coins smaller than i
	        for (int j=0; j<m; j++)
	          if (coins[j] <= i)
	          {
	              int sub_res = table[i-coins[j]];
	              if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
	                  table[i] = sub_res + 1;
	          }
	    }
	    return table[V];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int arr[] = {2, 5, 3, 6};
		
		System.out.println(CoinChangeWays(arr,arr.length,10));
		
		

	}

}
