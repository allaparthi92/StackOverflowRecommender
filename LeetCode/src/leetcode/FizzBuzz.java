package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void fizzBuzz(int n) {

		int fizz = 3;
		int Buzz = 5;
		int fizzbuzz = 15;
		List<String> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (i == fizzbuzz) {
				list.add("FizzBuzz");
				fizzbuzz = fizzbuzz + 15;
				
			} else if (i  == Buzz) {
				list.add("Buzz");
				Buzz = Buzz+5;
			} else if (i == fizz) {
				list.add("Fizz");
				fizz = fizz + 3;
			} else {
				list.add(String.valueOf(i));
			}
		}
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(15);
	}

}
