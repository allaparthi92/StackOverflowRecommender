import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Heaps {

	public static int parent(int i) {
		return i / 2;
	}

	public static void Heapify(int a[], int k, int n) {

		int leftchild = 2 * k + 1;
		int rightchild = 2 * (k + 1);

		int max = k;
		if (leftchild < n && a[leftchild] < a[k]) {
			max = leftchild;
		}
		if (rightchild < n && a[rightchild] < a[k]) {
			max = rightchild;
		}

		if (max != k) {
			if (rightchild < n && a[max] > a[leftchild]) {
				max = leftchild;
			}

			int temp = a[max];
			a[max] = a[k];
			a[k] = temp;

			Heapify(a, max, n);

		}

	}

	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (B > A.size())
			return result;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = A.size();
		for (int i = 0; i < n; i++) {

			if (hm.containsKey(A.get(i))) {
				hm.put(A.get(i), hm.get(A.get(i)) + 1);

			} else {
				hm.put(A.get(i), 1);

			}

			if (i >= B - 1) {

				result.add(hm.size());
				if (hm.get(A.get(i - B + 1)) == 1)
					hm.remove(A.get(i - B + 1));
				else
					hm.put(A.get(i - B + 1), hm.get(A.get(i - B + 1)) - 1);

			}

		}
		System.out.println(result);

		return result;
	}

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> hset = new HashSet<ArrayList<Integer>>();

		if (a.size() < 4)
			return result;
		Collections.sort(a);

		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				int k = j + 1;
				int l = a.size() - 1;
				while (k < l) {
					int sum = a.get(i) + a.get(j) + a.get(k) + a.get(l);
					if (sum < b) {
						k++;
					} else if (sum > b)
						l--;
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(a.get(i));
						list.add(a.get(j));
						list.add(a.get(k));
						list.add(a.get(l));
						if (!hset.contains(list)) {
							hset.add(list);
							result.add(list);
						}
						k++;
						l--;
					}
				}
			}
		}
		return result;

	}

	// Equal

	public static ArrayList<Integer> fourSumEqual(ArrayList<Integer> a, int b) {

		ArrayList<Integer> result = new ArrayList<>();

		Set<ArrayList<Integer>> hset = new HashSet<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		if (a.size() < 4)
			return result;
		for (int i = 0; i < a.size(); i++) {
			if (hm.containsKey(a.get(i))) {
				hm.get(a.get(i)).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				hm.put(a.get(i), list);
			}

		}

		Collections.sort(a);

		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				int k = 0;
				int l = a.size() - 1;
				while (k < l) {
					if (k == i || k == j) {
						k++;
						continue;
					}
					if (l == i || l == j) {
						l--;
						continue;
					}

					int sum = a.get(i) + a.get(j);
					int sum1 = a.get(k) + a.get(l);
					if (sum1 < sum) {
						k++;
					} else if (sum1 > sum)
						l--;
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						
//						list.add(hm.get(a.get(i)));
//						list.add(hm.get(a.get(j)));
//						list.add(hm.get(a.get(k)));
//						list.add(hm.get(a.get(l)));

						for (int m = 0; m < list.size(); m++) {
							if (result.size() == 0) {
								result = list;
								break;
							}
							if (list.get(m) < result.get(m)) {
								result = list;
								break;
							} else if (list.get(m) > result.get(m)) {
								break;
							}
						}
						k++;
						l--;

					}
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
		if (a.size() < 1) {
			return result;
		}

		for (int i = 0; i < a.size(); i++) {
			char y[] = a.get(i).toCharArray();
			Arrays.sort(y);
			String s = String.valueOf(y);
			if (hm.containsKey(s)) {
				hm.get(s).add(i + 1);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i + 1);
				hm.put(s, list);
			}
		}

		for (Map.Entry<String, ArrayList<Integer>> entry : hm.entrySet()) {
			if (entry.getValue().size() > 1) {
				result.add(entry.getValue());
			}
		}

		return result;
	}

	public static void main(String[] args) {
		//
		// int a[] = { 1, 2, 3, 4, 5, 67, 78, 90, 637673, 8838, 83883 };
		//
		// for (int i = a.length / 2; i >= 0; i--)
		// Heapify(a, i, a.length);
		// System.out.println(Arrays.toString(a));
		// for (int i = a.length - 1; i >= 0; i--) {
		// int temp = a[0];
		// a[0] = a[i];
		// a[i] = temp;
		//
		// Heapify(a, 0, i);
		// }
		// System.out.println(Arrays.toString(a));
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(3);
		result.add(4);
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		result.add(7);
		result.add(1);
		result.add(2);
		result.add(9);
		result.add(8);
		Set<ArrayList<Integer>> hset = new HashSet<ArrayList<Integer>>();
		hset.add(result);
		hset.add(result1);

		fourSumEqual(result, 3);
	}

}
