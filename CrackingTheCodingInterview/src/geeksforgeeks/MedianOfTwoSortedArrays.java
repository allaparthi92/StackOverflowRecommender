package geeksforgeeks;

public class MedianOfTwoSortedArrays {
	
	public static int Median(int a[],int b[]){
		int c[] = new int[a.length+b.length];
		int n =0;
		int y=0;
		int median =0;
		if(c.length%2==0){
			n = c.length/2-1;
			y = c.length/2-1;
		}else{
			n = c.length/2-1;
			y = (c.length/2);
		}
		int i=0, j=0;
		int counter =-1;
		while(i<a.length && j < b.length){
			if(a[i] > b[j] ){
				median =  b[j++];
				counter++;
			}else{
				median =  a[i++];
				counter++;
			}
			
			if(counter == y){
				
				//median =  (c[n]+ c[y])/2;
				break;
			}
		}
		System.out.println(median);
		return median;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int ar1[] = {1, 2, 3, 6};
		    int ar2[] = {4, 6, 8, 10};
		    Median(ar1,ar2);
	}

}
