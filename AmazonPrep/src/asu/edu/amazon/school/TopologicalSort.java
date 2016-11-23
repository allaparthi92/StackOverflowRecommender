package asu.edu.amazon.school;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Stack;

public class TopologicalSort {
	LinkedHashMap<Integer, ArrayList<Integer>> hmap = new LinkedHashMap<>();


	void topologicalsort(int V, int a[]) {
		Stack stack = new Stack();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices
		// one by one
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack, a);

		// Print contents of stack
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	private void topologicalSortUtil(int i, boolean[] visited, Stack stack,
			int a[]) {
		// TODO Auto-generated method stub
		visited[i] = true;

		ArrayList<Integer> list = hmap.get(a[i]);

		for (int j = 0; j < list.size(); i++) {
			if (visited[j] == false) {
				topologicalSortUtil(j, visited, stack, a);
			}
		}

		stack.push(a[i]);
	}
}
