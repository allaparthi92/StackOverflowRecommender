package programcreek;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		
		ExcelSheetNumber("AAA");
		ExcelSheetName(705);

	}
	
	

	private static void ExcelSheetName(int i) {
		StringBuilder sb = new StringBuilder();
		while(i > 0){
			i--;
			char ch = (char)(i%26+ 'A');
			
			i =i/26;
			sb.append(ch);
			
		}
			sb.reverse();
		System.out.println(sb.toString());
	}

	

	private static int ExcelSheetNumber(String string) {
		
		int n= string.length();
		int result = 0;
		for(int i=0;i<n;i++){
			int x = string.charAt(i);
			result = result *26 + (x-64);
		}
		return result;
	}

}
