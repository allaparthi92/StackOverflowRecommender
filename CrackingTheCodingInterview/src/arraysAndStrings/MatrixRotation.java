package arraysAndStrings;

import java.util.ArrayList;

public class MatrixRotation {

	public static void matrixRotation(int a[][], int n) {

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = a[i][j];

				a[i][j] = a[n - j - 1][i];
				a[n - j - 1][i] = a[n - i - 1][n - j - 1];

				a[n - i - 1][n - j - 1] = a[j][n - i - 1];

				a[j][n - i - 1] = temp;

			}
		}

	}
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
	    
	    for(int i=0;i<(a.size()/2);i++){
	        
	        for(int j=i;j<n-i-1;j++){
	            
	            int temp = a.get(i).get(j);
	            
	            a.get(i).set(j, a.get(n-j-1).get(i));
	            
	            a.get(n-j-1).set(i,a.get(n-i-1).get(n-j-1));
	            
	            a.get(n-i-1).set(n-j-1,a.get(j).get(n-i-1));
	            
	            a.get(j).set(n-i-1,temp);
	        }
	    }
	}

	void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
		
	}
}
