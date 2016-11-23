package dynamicprogramming;

public class LongestCommonSubstring {

	public static int longestCommonSubString(String a, String b) {
			
		int mat[][] = new int[a.length()+1][b.length()+1];
		
		for(int i=0;i<b.length()+1;i++){
			mat[0][i] = 0;
		}
		for(int i=0;i<a.length()+1;i++){
			mat[i][0] = 0;
		}
		int max = -1;
		
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				if(a.charAt(i)==b.charAt(j)){
					mat[i+1][j+1]= mat[i][j]+1;
					if( max < mat[i+1][j+1]){
						max = mat[i+1][j+1];
					}
				}else{
					mat[i][j] = 0;
				}
			}
		}
		System.out.println(max);
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestCommonSubString("abcd","acbcda");
	}

}
