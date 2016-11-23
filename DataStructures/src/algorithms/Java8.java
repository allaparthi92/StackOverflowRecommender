package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8 {

	public static void main(String args[])   {

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Comparator<Integer> comp = (x, y) -> {
			return x > y ? 1 : -1;
		};
		Collections.sort(list, comp);
		System.out.println(list);
		list.stream().sorted((x, y) -> {
			return x > y ? 1 : -1;
		}).forEach(x -> System.out.println(x));
		try{
		System.out.println("");
		}
		finally{
			
			System.out.println("");
		}
		
	}

}
