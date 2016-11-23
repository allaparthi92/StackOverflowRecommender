package programcreek;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int a[] = {3,2,4};
			int result[] = (TwoSum(a,6 ));
			System.out.println(result[0]+"-------->"+result[1]);
	}

	private static int[] TwoSum(int[] a, int target) {
		int result[] = new int[2];
		
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
		
			if(hm.containsKey(a[i])){
				int index = hm.get(a[i]);
				result[0] = index ;
				result[1] = i;
				break;
			}
			else
			{
				hm.put(target-a[i], i);
			}
		}
		return result;
	}

//	private static int[] TwoSum(int[] a, int target) {
//		// TODO Auto-generated method stub
//		int result[] = new int[2];
//		
//		int i=0;
//		int j = a.length-1;
//		while(i<j){
//			if(a[i] + a[j] > target){
//				j--;
//				continue;
//			}
//			else if(a[i] + a[j] < target){
//				++i;
//				continue;
//			}
//			else{
//				System.out.println(a[i]+"-------------"+a[j]);
//				result[0]=i;
//				result[1]=j;
//				break;
//			}
//		}
//		return result;
//	}

}
