package programcreek;

public class NumbertoWord {
	
	static String [] ones = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String [] twenty = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety","hundred"};
	static String[] hundreds = {"","thousand", "million","billion"};
	public static void main(String args[]){
		System.out.println(numberToWord(200));
	}
		
	public static String numberToWord(int num){
		
		String result1 = "";
		String finalresult = "";
		int place = 0;
		do {
			if(num!=0){
			int y =  num%1000;
			result1 = string1(y).toString();
			finalresult = result1 + " "+hundreds[place]+" "+finalresult ;
			}
			place++;
			num = num/1000;
		}while(num > 0);
		
		return finalresult;
		
	}
	
	static StringBuilder string1(int num){
		StringBuilder  result = new StringBuilder();
	while(num > 0){
		
		if(num > 0 && num < 20){
			result.append(" "+ones[num-1]);
			break;
		}

		if(num > 100 && num < 1000){
			int x  = num/100;
			num = num%100;
			 result.append(ones[x-1]).append(" hundred");
			continue;
		}
		if(num > 19 && num <= 100){
			int y  = num/10;
			num = num%10;
			 result.append(" "+twenty[y-1]);
			continue;
		}
		
		
		
	}
	return result;
	}
}
