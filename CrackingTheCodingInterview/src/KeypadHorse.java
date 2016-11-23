import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class KeypadHorse {
	static Map<Integer, List<String>> map = new HashMap<>();
	static Integer arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				buildNumber(i, j, "");
			}
		}
		System.out.println(s.size());
	}
	static Set<String> s = new HashSet<>();
	public static void buildNumber(int i, int j, String num) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return;
		}
		if (arr[i][j] == -1) {
			return;
		}
		if (num.length() == 10) {
			s.add(num);
			return;
		}
		buildNumber(i + 1, j + 2, num + arr[i][j]);
		buildNumber(i - 1, j + 2, num + arr[i][j]);
		buildNumber(i + 1, j - 2, num + arr[i][j]);
		buildNumber(i - 1, j - 2, num + arr[i][j]);
		buildNumber(i + 2, j + 1, num + arr[i][j]);
		buildNumber(i + 2, j - 1, num + arr[i][j]);
		buildNumber(i - 2, j - 1, num + arr[i][j]);
		buildNumber(i - 2, j + 1, num + arr[i][j]);
	}
}