package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.List;

class TreeNodeList {
	int val;
	List<TreeNodeList> children = new ArrayList<TreeNodeList>();

}

class Avg {
	int sum;
	int num;

	public Avg(int sum, int num) {
		this.sum = sum;
		this.num = num;
	}

}

public class NArrayTree {
	static float maxavg = -1;

	public static Avg TreeAvg(TreeNodeList root) {
		if (root == null) {
			return null;
		}
		int sum = 0;
		int num = 0;
		for (TreeNodeList node : root.children) {
			Avg a = TreeAvg(node);
			sum += a != null ? a.sum : 0;
			num += a != null ? a.num : 0;
		}
		float avg = (float) (sum + root.val) / (num + 1);
		maxavg = Math.max(avg, maxavg);
		return new Avg(sum + root.val, num + 1);
	}

	public static void main(String[] args) {

		TreeNodeList root = new TreeNodeList();
		root.val = 5;
		TreeNodeList child1 = new TreeNodeList();
		child1.val = 1;
		TreeNodeList child2 = new TreeNodeList();
		child1.val = 2;
		TreeNodeList child3 = new TreeNodeList();
		child1.val = 3;

		root.children.add(child1);
		root.children.add(child2);
		root.children.add(child3);
		TreeAvg(root);
		System.out.println(maxavg);

	}
}
