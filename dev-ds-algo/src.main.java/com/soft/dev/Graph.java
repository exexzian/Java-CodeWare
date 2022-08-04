package com.soft.dev;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;

	Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}

		queue = new LinkedList<>();
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
	
	void bfs(int n) {
		boolean visited[] = new boolean[V];
		visited[n]=true;
		
		queue.add(n);
		int temp = 0;
		
		while(queue.size() != 0) {
			
			n = queue.poll();
			System.out.print(" " + n);
			
			for (int i = 0; i < adj[n].size(); i++) {
				temp = adj[n].get(i);
				if(!visited[temp]) {
					queue.add(temp);
					visited[temp] = true;
				}
				
			}
		}
	}
	
	void shortestPathNodes_BFS(int src,int dest) {
		boolean visited[] = new boolean[V];
		int[] parent = new int[adj.length];
		
		parent[src]	= -1;
		visited[src]=true;
		
		queue.add(src);
		int curr = 0;
		
		while(queue.size() != 0) {
			curr = queue.poll();
			if(curr == dest) { break; }
			
			for(int neighbor: adj[curr]) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
					parent[neighbor] = curr;
				}
			}
		}
		System.out.println("parent:\n"+Arrays.toString(parent));
		
		curr = dest;
		int dist = 0;
		while(parent[curr] != -1) {
			System.out.print(curr +" -> ");
			curr = parent[curr];
			dist++;
		}
		System.out.print(src);
		System.out.println("\n distance: "+dist);
	}
	
	
	public void dfs_recursion(int root) {
		boolean[] visited = new boolean[V];
		dfsUtil(root,visited);
	}

	public void dfsUtil(int root, boolean[] visited) {
		visited[root] = true;
		System.out.print(root + " ");

		for (int curr : adj[root]) {
			
			if(!visited[curr]) {
				dfsUtil(curr, visited);
			}
		}
	}
	
	
	
	
	

	public static void main(String args[]) {
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(4, 5);
		graph.addEdge(3, 5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(2, 1);
		graph.addEdge(4, 1);
		graph.addEdge(3, 1);
		graph.addEdge(5, 4);
		graph.addEdge(5, 3);

		/*
		System.out.println("The Breadth First Traversal of the graph is as follows :");
		graph.bfs(0);
		
		System.out.println("\nShortest path between two nodes: ");
		graph.shortestPathNodes_BFS(1,3);
		*/
		System.out.println("The Depth First Traversal of the graph is as follows:");
		graph.dfs_recursion(0);
		
	}

	public boolean isCycle(int src) {
		
		boolean hasCycle = false;
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		
		for (int i : parent) {
			parent[i] = -2;
		}
		
		queue = new LinkedList<Integer>();

		parent[src] = -1;
		queue.add(src);
		
		visited[src] = true;
		
		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			
			for (int neighbour : adj[curr]) {
				
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					parent[neighbour] = curr;
					queue.add(neighbour);
				}else {
					if(parent[neighbour] != -2) {
						parent[neighbour] = curr;
						System.err.println("detected cycle at : ");
						System.err.println("cur: " + curr);
						System.err.println("neighbour: " + neighbour);
						queue.clear();
						hasCycle = true;
					}
				}
				
				
			}
			
		}
		
		System.out.println("parent: " + Arrays.toString(parent));
		
		return hasCycle;
	}

}
