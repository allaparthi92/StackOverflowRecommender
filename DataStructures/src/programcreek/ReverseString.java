package programcreek;

import java.util.ArrayList;

public class ReverseString {

	public void reverseString(char[] str){
		int length = str.length;
		int k=0;
		for(int i=0;i<length;i++){
			if(str[i]==' '){
				reverse(str,k,i-1);
				k= i+1;
			}
		}
		reverse(str,k,length-1);
		reverse(str,0,length-1);
		System.out.println(str);
	}

	private void reverse(char[] a, int start, int end) {
		while(start<end){
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		
	}
	
	public static ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 0; a * a < A; a++) {
			for (int b = a; b * b < A; b++) {
				if (a * a + b * b == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}
	public static void main(String args[]){
		ReverseString r = new ReverseString();
		String str ="the sky is blue";
		System.out.println(squareSum(10));
		r.reverseString(str.toCharArray());
		
	}
}
