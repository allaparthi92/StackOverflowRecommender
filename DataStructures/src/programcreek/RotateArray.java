package programcreek;

public class RotateArray {
	/*
	 * Rotate an array by given k steps
	 * The idea is divide the given array in to two parts based on k 
	 * Reverse the first part and reverse the second then reverse the entire array
	 */
	public int[] RotataeArray(int array[],int k){
		
		int length = array.length;
		if(length==0 || k<0)
			System.out.println("cannot rotate an array");
		
		if(k> length){
			k=k%length;
		}
		
		reverse(array, 0 ,length-k-1 );
		reverse(array,length-k,length-1);
		reverse(array,0,length-1);
		return array;
	}

	private void reverse(int[] a, int start, int end) {
		
		while(start<end){
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
	
		RotateArray a = new RotateArray();
		int b[] = {1,2,3,4,5,6,7};
		a.RotataeArray(b, 3);
		for(int i:b)
			System.out.print(i+"-->");
	}

}
