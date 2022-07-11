package neetcode.graphs;

import java.util.*;

class GraphAdjacencyList {
	
	private int V; 
	private LinkedList<Integer> adj[];

	GraphAdjacencyList(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.println(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	void DFS()
	{
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			if (visited[i] == false)
				DFSUtil(i, visited);
	}
	
	void BFS(int v) {
		boolean visited[] =new boolean[V];
		LinkedList<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		while(q.size()!= 0) {
			v = q.poll();
			System.out.println(" "+v);
			Iterator<Integer> it = adj[v].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					q.add(n);
					visited[n] = true;
				}
			}
		}
	}


	public static void main(String args[])
	{
		GraphAdjacencyList g = new GraphAdjacencyList(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.DFS();
		System.out.println(
			"Following is Depth First Traversal");
		g.BFS(2);
		System.out.println(
				"Following is Depth First Traversal");
		
	}
}
