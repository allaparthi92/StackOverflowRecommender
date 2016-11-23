package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	static List<String> hset = new ArrayList<>();

	private static void swap(StringBuffer str, int pos1, int pos2) {
		char t1 = str.charAt(pos1);
		str.setCharAt(pos1, str.charAt(pos2));
		str.setCharAt(pos2, t1);
	}

	void permute(StringBuffer a, int l, int r) {
		if (l == r) {
			System.out.println(a);
			hset.add(a.toString());
		} else {
			for (int i = l; i <= r; i++) {
				swap(a, l, i);
				permute(a, l + 1, r);
				swap(a, l, i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations perm = new Permutations();
		StringBuffer b = new StringBuffer("ABC");
		perm.permute(b, 0, b.length() - 1);
		System.out.println(hset);
	}

}
