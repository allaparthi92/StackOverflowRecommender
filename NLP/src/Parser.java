import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("all")
public class Parser {

	public static ConcurrentHashMap<String, ArrayList<ArrayList<String>>> hm = new ConcurrentHashMap<>();

	public static HashMap<String, ArrayList<Integer>> finalhm = new HashMap<>();

	public static HashMap<String, Integer> weightedfinalhm = new HashMap<>();

	public static void CSVReader() throws IOException {

		String csvFile = System.getProperty("user.dir") + "\\src\\Data";
		String csvFile1 = System.getProperty("user.dir") + "\\src\\D2.csv";
		FileWriter writer = new FileWriter(csvFile1);
		String csvFile2 = System.getProperty("user.dir") + "\\src\\D3.csv";
		FileWriter writer2 = new FileWriter(csvFile2);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int count = 0;
		boolean flag = false;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				count++;
				if (count == 1)
					continue;
				// use comma as separator

				String[] country = line.split(cvsSplitBy);
				for (int i = 0; i < country.length; i++) {
					if (country[i].equals("")) {
						flag = true;
					}
				}
				if (flag) {
					flag = false;
					continue;
				}
				ArrayList sub = new ArrayList<>();

				ArrayList<String> subwinner = new ArrayList<String>();
				ArrayList<String> sublooser = new ArrayList<String>();
				for (int i = 2; i < country.length; i = i + 2) {

					subwinner.add(country[i]);
				}

				for (int i = 3; i < country.length; i = i + 2) {

					sublooser.add(country[i]);
				}

				if (!hm.containsKey(country[0])) {
					ArrayList<ArrayList<String>> winner = new ArrayList<>();
					winner.add(subwinner);
					hm.put(country[1], winner);
				} else {
					hm.get(country[0]).add(subwinner);
				}
				if (!hm.containsKey(country[1])) {
					ArrayList<ArrayList<String>> looser = new ArrayList<>();
					looser.add(sublooser);
					hm.put(country[1], looser);
				} else {
					hm.get(country[1]).add(sublooser);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		for (Map.Entry entry : hm.entrySet()) {
			if (hm.get(entry.getKey()).size() < 8) {
				hm.remove(entry.getKey());
			}
		}
		int counter = 0;

		for (Map.Entry entry : hm.entrySet()) {
			int avg = 0;
			int acecount = 0;
			int breakcount = 0;
			int winner = 0;
			int returncount = 0;
			int doublefault = 0;
			int net = 0;
			int error = 0;
			counter++;
			ArrayList<ArrayList<String>> al = hm.get(entry.getKey());

			for (ArrayList<String> list : al) {
				if (list.size() != 7)
					continue;
				if (list.get(0).equals("") || list.get(1).equals("")
						|| list.get(2).equals("") || list.get(2).equals("-")
						|| list.get(3).equals("") || list.get(4).equals("")
						|| list.get(5).equals("") || list.get(6).equals("")
						|| list.get(6).equals("-")) {
					continue;
				}
				acecount = acecount + Integer.parseInt(list.get(0));
				doublefault = doublefault + Integer.parseInt(list.get(1));

				breakcount = breakcount
						+ Integer.parseInt(list.get(2).substring(0,
								list.get(2).length() - 1));
				winner = winner + Integer.parseInt(list.get(3));
				returncount = returncount
						+ Integer.parseInt(list.get(4).substring(0,
								list.get(4).length() - 1));
				error = error + Integer.parseInt(list.get(5));
				net = net
						+ Integer.parseInt(list.get(6).substring(0,
								list.get(6).length() - 1));
			}
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			list1.add(acecount * 10);
			list1.add(doublefault * -5);
			list1.add(((Integer) breakcount / al.size()) * 5);
			list1.add(winner * 10);
			list1.add(((Integer) returncount / al.size()) * 5);
			list1.add(error * -5);
			list1.add(((Integer) net / al.size()) * 5);
			list1.add(al.size());
			avg = avg + (acecount * 10) + (doublefault * -5)
					+ ((Integer) breakcount / al.size() * 5) + (winner * 10)
					+ ((Integer) returncount / al.size() * 5) + (error * -5)
					+ (((Integer) net / al.size()) * 5);

			writer.write(entry.getKey() + "," + acecount + "," + doublefault
					+ "," + (Integer) breakcount / al.size() + "," + winner
					+ "," + (Integer) returncount / al.size() + "," + error
					+ "," + (Integer) net / al.size() + "," + avg +"," + al.size() + "\n");
			finalhm.put((String) entry.getKey(), list1);

		}
		writer.flush();
		writer.close();

		for (Map.Entry entry : finalhm.entrySet()) {
			int weightedavg = 0;
			ArrayList<Integer> x = finalhm.get(entry.getKey());
			for (Integer y : x) {
				weightedavg = weightedavg + y;
			}
			weightedfinalhm.put((String) entry.getKey(), weightedavg);
			writer2.write(entry.getKey() + "," + weightedavg + "\n");

		}
		writer2.flush();
		writer2.close();

		System.out.println(weightedfinalhm);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CSVReader();
	}

}
