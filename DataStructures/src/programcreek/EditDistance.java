package programcreek;

public class EditDistance {
	
	
	public static void main(String[] args) {
			String word1 = "b";
			String word2 = "a";
			System.out.println(editDistance(word1,word2));
			
	}

	private static int editDistance(String word1, String word2) {
		
		int len1 = word1.length();
		int len2 = word2.length();
		int m[][] = new int[len1+1][len2+1];
		for(int i=0 ; i<=len1;i++){
			m[i][0] = i;
		}
		
		for(int k=0 ; k<=len2;k++){
			m[0][k] = k;
		}
		
		for(int i=0;i<len1;i++){
			
			for(int j=0;j<len2;j++){
				if(word1.charAt(i)==word2.charAt(j))
					m[i+1][j+1] = m[i][j];
				else{
					int x1 = m[i][j+1] +1;
					int x2 = m[i+1][j]+1;
					int x3 = m[i][j]+1;
					
					int min = Math.min(x1, x2);
					min = Math.min(min, x3);
					m[i+1][j+1]= min;
				}
			}
		}
		return m[len1][len2];
	}

}
