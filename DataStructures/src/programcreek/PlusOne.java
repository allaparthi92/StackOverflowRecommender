package programcreek;

public class PlusOne {

	public static void main(String[] args) {
		int a[]={9,9,9};
		System.out.println(PlusOne(a));
	}

	private static int[] PlusOne(int[] a) {
		for(int i=a.length-1;i>=0;i--){
			if(a[i]!=9){
				a[i]++;
				break;
			}
			else
				a[i]= 0;
		}
		
		if(a[0]==0){
			int result[] = new int[a.length+1];
			result[0] = 1;
			return result;
		}
			return a;
	}

}
