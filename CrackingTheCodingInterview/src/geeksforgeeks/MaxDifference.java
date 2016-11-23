package geeksforgeeks;

public class MaxDifference {
	
	public static void MaxDiff(int a[]){
		
		int min = a[0];
		
		int maxdiff = a[1] - a[0];
		
		for(int i=1;i<a.length;i++){
			if(a[i]- min > maxdiff){
				maxdiff = a[i]- min ;
			}
			
			if(a[i]< min){
				min = a[i];
			}
		}
		System.out.println( maxdiff);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 6, 80, 100};
		 MaxDiff(arr);
	}

}
