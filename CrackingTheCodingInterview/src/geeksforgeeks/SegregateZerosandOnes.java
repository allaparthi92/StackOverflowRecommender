package geeksforgeeks;

import java.util.Arrays;


public class SegregateZerosandOnes {
	public static void segregate(int a[]){
		int counter= a.length-1;
		for(int i=counter;i >=0;i--){
			if(a[i]!=0){
				a[counter--] = a[i];
			}
		}
		int temp = counter +1;
		 counter =0;
		while(counter< temp){
			a[counter++] = 0;
		}
		System.out.println(Arrays.toString(a));
	}
	public static void segregateEvenandOdd(int a[]){
		int counter= a.length-1;
		int b[] = new int[counter+1];

	
		for(int i=counter;i >=0;i--){
			if(a[i]%2!=0){
				a[counter--] = a[i];
			}
		}
		int temp = counter +1;
		 counter =0;
		 int i=0;
		while(counter< temp && i< a.length-1 ){
			if(a[i]%2==0){
				a[counter++] = a[i];
			}
			i++;
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		 int arr[] = {0, 1, 0, 1, 1, 1,2,0,0,0,0,0,4,5,6,7,8,0};
		 int ar[] = {12, 34, 45, 9, 8, 90, 3};
		 segregate(arr);
		 segregateEvenandOdd(ar);
	}
}
