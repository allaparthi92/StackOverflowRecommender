package programcreek;

public class CountPrimes {

	public static void main(String[] args) {
		
		int n = 499979;
		System.out.println(CountPrimeNumbers1(n));
	}
	
	private static int CountPrimeNumbers1(int n) {
		boolean[] a = new boolean[n];
			int count =0;
		for(int i=2;i<n;i++){
			if(a[i])
				continue;
			count++;
			for(int j=i;j<n;j=j+i)
				a[j]=true;
		}
		return count;
		
		}
	

	private static int CountPrimeNumbers(int n) {
		   int count = 0;
			int primecount =0;
			if(n <= 2)
	            return 0;
			if(n==3)
				return 1;
			if(n >3){
			for(int i=3;i<n;i=i+2){
				for(int j=1;j<=(int)Math.sqrt(i);j=j+2){
					if(i%j==0)
						count++;
					
				}
				if(count==1)
					primecount++;
				count =0;
			}
			}
			return primecount+1;
		
		}
	
	
}
