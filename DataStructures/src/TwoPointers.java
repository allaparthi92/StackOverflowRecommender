import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class TwoPointers {

	public int threeSumClosest(ArrayList<Integer> nums, int b) {

		Collections.sort(nums);
		int closest = nums.get(0) + nums.get(1) + nums.get(2);
		int low, high;
		for (int i = 0; i < nums.size() - 1; i++) {
			low = i + 1;
			high = nums.size() - 1;
			while (low < high) {
				if (nums.get(low) + nums.get(high) == b - nums.get(i))
					return b;
				else if ((nums.get(low) + nums.get(high) > b - nums.get(i))) {
					while (low < high
							&& nums.get(low) + nums.get(high) > b - nums.get(i))
						high--;
					if (Math.abs(nums.get(i) + nums.get(low)
							+ nums.get(high + 1) - b) < Math.abs(closest - b))
						closest = nums.get(i) + nums.get(low)
								+ nums.get(high + 1);
				} else {
					while (low < high
							&& nums.get(low) + nums.get(high) < b - nums.get(i))
						low++;
					if (Math.abs(nums.get(i) + nums.get(low - 1)
							+ nums.get(high) - b) < Math.abs(closest - b))
						closest = nums.get(i) + nums.get(low - 1)
								+ nums.get(high);
				}
			}
		}
		return closest;
	}

	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums) {

		ArrayList<ArrayList<Integer>> main = new ArrayList<ArrayList<Integer>>();

		Collections.sort(nums);
		int low, high;
		for (int i = 0; i < nums.size() - 1; i++) {
			low = i + 1;
			high = nums.size() - 1;
			while (low < high) {
				if (nums.get(low) + nums.get(high) == 0 - nums.get(i)) {
					ArrayList<Integer> subres = new ArrayList<Integer>();
					subres.add(nums.get(i));
					subres.add(nums.get(low));
					subres.add(nums.get(high));
					Collections.sort(subres);
					if (!main.contains(subres))
						main.add(subres);
					low++;
					high--;
				} else if (nums.get(low) + nums.get(high) + nums.get(i) < 0)
					low++;
				else {
					high--;
				}
			}
		}
		return main;
	}

	public static int diffPossible(ArrayList<Integer> a, int b) {
		if (a == null || a.size() <= 1)
			return 0;
		int i = 0;
		int j = 1;
		while (j < a.size() && i < a.size()) {

			int diff = a.get(j) - a.get(i);

			if (diff == b && i != j)
				return 1;
			else if (diff < b)
				j++;
			else
				i++;

		}
		return 0;

	}

	public static ArrayList<Integer> intersect(final List<Integer> a,
			final List<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (a == null || b == null)

			return null;

		int i = 0;
		int j = 0;

		while (i < a.size()) {
			if (a.get(i) == b.get(j)) {
				result.add(a.get(i));
				i++;
				j++;
			} else {
				i++;

			}
		}
		return result;
	}

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

		int i = 0;
		int j = 0;
		boolean flag = false;
		int n = a.size();
		for (int k = 0; k < b.size(); k++) {
			a.add(Integer.MIN_VALUE);
		}
		while (i < a.size()) {
			if (a.get(i) > b.get(j)) {
				int temp = a.get(i);
				a.set(i, b.get(j));
				b.set(j, temp);
				if (flag) {
					i++;
				}
				if (b.get(j) > b.get(j + 1)) {
					int temp1 = b.get(j);
					b.set(j, b.get(j + 1));
					b.set(j + 1, temp1);
					flag = true;
				} else {
					i++;
				}
			} else {
				i++;
			}

		}
		int m = 0;
		for (int i1 = n; i1 < a.size(); i1++) {
			a.set(i1, b.get(m));
			m++;
		}
	}

	public static void merge1(ArrayList<Integer> a, ArrayList<Integer> b) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < a.size() && j < b.size()) {
			if (a.get(i) > b.get(j)) {
				result.add(b.get(j));
				j++;
			} else {
				result.add(a.get(i));
				i++;
			}
		}

		while (i < a.size()) {
			result.add(a.get(i));
			i++;
		}
		while (j < b.size()) {
			result.add(b.get(j));
			j++;
		}

		a = result;
		System.out.println(a);
	}

	public static int removeDuplicates(ArrayList<Integer> a) {

		int index = 1;
		System.out.println(a);
		for (int i = 1; i < a.size(); i++) {
			if (!a.get(i).equals(a.get(i - 1))) {

				a.set(index, a.get(i));
				index++;
			}
		}
		System.out.println(a);
		return index;
	}

	public static int removeDuplicates1(ArrayList<Integer> a) {
		int count = 0;
		int index = 1;
		int i = 1;

		while (i < a.size()) {

			if (count == 0) {
				if (a.get(i) == a.get(i - 1)) {
					i++;
					count++;
					index++;
				} else {
					i++;
					index++;
				}

			} else if (count == 1) {
				if (a.get(i) == a.get(i - 1)) {
					index++;
					i++;
					count++;
				}
			}

			else if (count > 1) {
				int j = i;
				while (j < a.size() && a.get(j) == a.get(i)) {
					j++;
				}
				count = 0;
				i = j;
				a.set(index, a.get(i));
			}

		}
		System.out.println(index--);
		return index--;
	}

	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(a==null || a.size()==0)
			return a;
		int n = b;
		int j = 0;
		int count = 0;
		int maxcount = Integer.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			for (j = i; j < a.size(); j++) {
				if (a.get(j) == 1) {
					count++;

				} else if (a.get(j) == 0 && n > 0) {
					count++;
					n--;
				} else {

					break;

				}

			}
			if (count > maxcount) {
				maxcount = Math.max(count, maxcount);
				result.clear();
				int len = j-i;
				int m = i;
				for(int k=0;k< len;k++){
					result.add(m);
					m++;
				}
			}
			count = 0;
			n = b;
		}
		System.out.println(result);
		return result;

	}
	
	public static int maxArea(ArrayList<Integer> a) {
		int maxArea = Integer.MIN_VALUE;
		int area =0;
		if(a==null || a.size()==0)
			return 0;
		for(int i=0; i < a.size();i++){
			for(int j=i+1;j< a.size();j++){
				area = Math.min(a.get(i), a.get(j)) * (j-i);
				maxArea = Math.max(area, maxArea);
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
	
		a.add(5);
		a.add(4);
		a.add(3);

		ArrayList<Integer> b = new ArrayList<Integer>();

		b.add(-2);
		a.clear();
		System.out.println(maxArea(a));
	}

}
