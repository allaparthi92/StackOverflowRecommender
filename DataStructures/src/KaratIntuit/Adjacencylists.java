package KaratIntuit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Adjacencylists {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		while(sc.hasNext()){
//			String x = sc.next();
//			System.out.println(x);
//		}
		
		Logger logger = Logger.getLogger("myLogger");
//		
		ReadCSV csvReader = new ReadCSV();
		String employeecsvpath = System.getProperty("user.dir")+"\\src\\KaratIntuit\\employee.csv";
		String friendshippath = System.getProperty("user.dir")+"\\src\\KaratIntuit\\friendships.csv";
		
		csvReader.readCsvFile(employeecsvpath, "EMP");
		csvReader.readCsvFile(friendshippath, "");
		
		HashMap<Integer,HashSet<Integer>> result = new HashMap<Integer,HashSet<Integer>>();
		
		for(Employee emp : csvReader.getEmployeelist()){
			result.put(emp.getEmployee_id(), new HashSet<Integer>());
		}
		
		for(Friendships frnd : csvReader.getFriendshiplist()){
			result.get(frnd.getId_1()).add(frnd.getId_2());
			result.get(frnd.getId_2()).add(frnd.getId_1());
		}
		
		for(Map.Entry<Integer, HashSet<Integer>> entry : result.entrySet()){
			System.out.print(entry.getKey()+": ");
			if(entry.getValue().size()==0){
				System.out.println("None");
			}
			else{
				StringBuilder sb = new StringBuilder();
				for(Integer x : entry.getValue()){
					sb.append(x).append(", ");
				}
				System.out.println(sb.substring(0, sb.length()-2));
			}
		}
	
	DataLoader loader = DataLoaderFactory.getInStance("csv");

				
		
		
	}
	

}
