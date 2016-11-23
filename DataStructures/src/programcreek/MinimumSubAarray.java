package programcreek;

public class MinimumSubAarray {

	public static void main(String[] args) {
		int a[]={ 2,3,1,2,4,3};
		System.out.println(minimumSubArray(a,7));
	}

	private static int  minimumSubArray(int[] a,int target) {
		int sum =0;
		int min =Integer.MAX_VALUE;
		int k=0;
		for(int i=0;i<a.length;i++){
			sum = sum +a[i];
			//System.out.println("sum"+sum);
			while(sum >= target){
				min = Math.min(min,i+1-k);
				System.out.println(min);
				sum = sum-a[k];		
				k++;
			}
			}
		return min;
	}

}
