package KaratIntuit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	private  ArrayList<Employee> employeelist = new ArrayList<Employee>();
	private  ArrayList<Friendships> friendshiplist = new ArrayList<Friendships>();

	private static final String COMMA_DELIMITER = ",";
	private static final int EMPLOYEE_ID = 0;
	private static final int EMPLOYEE_NAME = 1;
	private static final int EMPLOYEE_DEPT = 2;
	private static final int FRND_ID_1 = 0;
	private static final int FRND_ID_2 = 1;

	public void readCsvFile(String fileName, String fileType) {
		// BufferedReader fileReader = null;
		try (BufferedReader fileReader = new BufferedReader(new FileReader(
				fileName))) {
			String line = "";
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					if (fileType.equals("EMP")) {
						Employee emp = new Employee(
								Integer.parseInt(tokens[EMPLOYEE_ID]),
								tokens[EMPLOYEE_NAME], tokens[EMPLOYEE_DEPT]);
						employeelist.add(emp);
					} else {
						Friendships frnd = new Friendships(
								Integer.parseInt(tokens[FRND_ID_1]),
								Integer.parseInt(tokens[FRND_ID_2]));
						friendshiplist.add(frnd);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in CsvFileReader !!!");
		}
	}

	public ArrayList<Employee> getEmployeelist() {
		return employeelist;
	}

	public ArrayList<Friendships> getFriendshiplist() {
		return friendshiplist;
	}
}
