package dynamicprogramming;

public class EditDistance {
	
	public static int editDistance(String a ,String b){
		
		int mat[][] = new int[a.length()+1][b.length()+1];
		
		for(int i=0;i<b.length()+1;i++){
			mat[0][i] = i;
		}
		for(int j=0;j<a.length()+1;j++){
			mat[j][0] = j;
		}
		
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				if(a.charAt(i)== b.charAt(j)){
					mat[i+1][j+1]=mat[i][j];
				}else{
					int replace = mat[i][j] +1;
					int delete =  mat[i+1][j] +1;
					int insert = mat[i][j+1] +1;
					int minimum = replace > delete ? delete :replace;
					int min = insert > minimum ? minimum: insert;
					mat[i+1][j+1] = min;
				}
			}
		}
		System.out.println(mat[a.length()][b.length()]);
		return mat[a.length()][b.length()];
	}
	
	public static void main(String args[]){
		editDistance("abc","def");
	}
}
