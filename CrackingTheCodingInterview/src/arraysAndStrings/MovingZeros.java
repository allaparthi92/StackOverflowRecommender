package arraysAndStrings;

import java.util.Arrays;

public class MovingZeros {

	public static void movingZeros(int arr[]) {

		int start = 0;
		int end = arr.length-1;

		while (start < end) {

			if (arr[start] == 0) {

				if (arr[end] == 0)
					end--;
				else {
					int temp = arr[end];
					arr[end] = arr[start];
					arr[start] = temp;
					start++;
					end--;
				}
			} else {
				start++;

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,0,6,7,0,0,0,8};
		movingZeros(a);
		System.out.println(Arrays.asList(a));
	}

}
