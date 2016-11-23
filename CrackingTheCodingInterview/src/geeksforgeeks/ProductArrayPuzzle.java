package geeksforgeeks;

public class ProductArrayPuzzle {
	
	public static void ProductArray(int a[]){
		
		int left[] = new int [a.length];
		
		int right[] = new int [a.length];
		
		int result[] = new int [a.length];
		
		int start =0;
		int end = a.length-1;
		left[start] = 1;
		for(int i=1;i<a.length;i++){
			left[i] = left[i-1]*a[i-1];
			//System.out.println(left[i]);
		}
		
		right[end] = 1;
		for(int i=end-1;i>=0;i--){
			
			right[i] = right[i+1]*a[i+1];
			//System.out.println(right[i]);
		}
		start =0;
		end = a.length-1;
		while(start <= end){
			
			result[start] = left[start]*right[start];
			System.out.println(result[start]);
			start++;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 3, 5, 6, 2};
		ProductArray(arr);
	}
	

}
