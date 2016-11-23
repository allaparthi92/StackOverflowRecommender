package programcreek;

public class SearchInsertPosition {
	
	static int SearchInsertPosition(int a[],int target){
		int low =0;
		int high = a.length-1;
		while(low <= high){
			int mid = ((low+high)/2);
			
			if(a[mid]==target){
				return mid;
			}
			else if(a[mid]< target){
				
				low = mid+1;
				
			}
			else {
				high = mid-1;
			}
		}
			return (low);		
		
		
	}
	
	public static void main(String[] args) {
		int a[]={1,2,3,8,9,10};
		System.out.println(SearchInsertPosition(a,7));
		
		
		
	}

}
