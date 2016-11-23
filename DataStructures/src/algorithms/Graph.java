package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	int v;
	LinkedList<Integer> adj[];

	@SuppressWarnings("all")
	Graph(int v) {
		this.v= v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
	
	 void addEdge(int v,int w)
	    {
	        adj[v].add(w);
	    }
	 
	 public void bfs(int vertex){
		 ArrayList<Integer> al = new ArrayList();
		 
		Queue<Integer>  q = new LinkedList<Integer>();
		
		q.add(vertex);
		al.add(vertex);
		while(!q.isEmpty()){
			int x = q.poll();
			System.out.print(x+"-->");
			 Iterator<Integer> i = adj[x].listIterator(); 
			
			while(i.hasNext()){
				int n = i.next();
				if(!al.contains(n)){
					al.add(n);
					q.add(n);
				}
			}
		}
		
	 }
	 

		void dfs(int x){
			boolean[] visited = new boolean[v];
			dfsUtil(x,visited);
			for(int i=0;i<v;i++){
				if(visited[i]==false)
					dfsUtil(i,visited);
			}
		}
	 
	   private void dfsUtil(int i, boolean[] visited) {
		   visited[i]=true;
		   System.out.print(i+"-->");
		   Iterator<Integer> k = adj[i].listIterator(); 
		   while(k.hasNext()){
			   int n = k.next();
			   if(!visited[n])
				   dfsUtil(n,visited);
		   }
			
		}

	public static void main(String args[])
	    {
	        Graph g = new Graph(4);
	 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        g.bfs(2);
	        System.out.println();
	        g.dfs(2);
	    }
}
