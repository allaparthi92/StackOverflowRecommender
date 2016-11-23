package programcreek;

public class MultiplyStrings {

	public static void main(String[] args) {
		String a = "123";
		String b = "144";
		MultiplyStrings(a,b);
	}

	private static void MultiplyStrings(String a, String b) {
		int p[] = new int[a.length()+b.length()];
		for(int i= a.length()-1;i>=0;i--){
			for(int j=b.length()-1;j>=0;j--){
				int index =a.length()+b.length()-i-j-2;
				int mul = (a.charAt(i)-'0') * (b.charAt(j)-'0');
				
				p[index] = p[index] + mul;
				
				p[index+1] = p[index+1] + (p[index]/10);
				
				p[index] = p[index]%10;
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = p.length-1; i>0; i--) {
			if(sb.length()==0 && p[i]==0)
				continue;
			sb.append(p[i]);
			
		}
		System.out.println(sb.toString());
	}

}
