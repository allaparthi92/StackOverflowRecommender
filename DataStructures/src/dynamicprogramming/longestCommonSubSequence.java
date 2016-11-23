package dynamicprogramming;

public class longestCommonSubSequence {

	public static int longestCommonsequence(String a, String b) {

		if (a == null || b == null) {
			return 0;
		}
		if (a.length() == 0 || b.length() == 0) {
			return 0;
		}

		if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
			return 1 + longestCommonsequence(a.substring(0, a.length() - 1),
					b.substring(0, b.length() - 1));
		} else {
			return Math.max(
					longestCommonsequence(a, b.substring(0, b.length() - 1)),
					longestCommonsequence(a.substring(0, a.length() - 1), b));
		}
	}

	public static int longestCommonsequenceDp(String a, String b) {
		
		int mat[][] = new int [a.length()+1][b.length()+1];
		
		for(int i=0;i<b.length()+1;i++){
			mat[0][i] = 0;
		}
		for(int i=0;i<a.length()+1;i++){
			mat[i][0] = 0;
		}
		
		
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				if(a.charAt(i)==b.charAt(j)){
					mat[i+1][j+1] = mat[i][j]+1;
				}else{
					
					int max = Math.max(mat[i+1][j], mat[i][j+1]);
					mat[i+1][j+1] =  max;
				}
			}
		}
		
		return mat[a.length()][b.length()];
		
		
	}

	public static void main(String[] args) {

		System.out.println(longestCommonsequenceDp("abcde", "abhhhhhhggggggcde"));
	}

}
