package com.soft.dev;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DFS_Stack {
	
	private int V;
	private LinkedList<Integer>[] adj;
	private Stack<Integer> stack;
	
	public DFS_Stack(int V) {
		
		this.V = V;
		adj = new LinkedList[V];
		
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList();
		}
	
	}
	
	public void addEdge(int node, int nieghbour) {
		adj[node].add(nieghbour);
	}
	
	
	public void dfs_stack(int root) {
		
		
		System.out.println("adj ary: " + Arrays.toString(adj));
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			int curr = stack.pop();
			if(!visited[curr]) {
				visited[curr] = true;
				System.out.print(curr + " ");
			}
			
			for (int neighbour : adj[curr]) {
				
				if(!visited[neighbour]) {
					stack.push(neighbour);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		DFS_Stack graph = new DFS_Stack(6);

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

		System.out.println("The Depth First Traversal of the graph using stack is as follows:");
		graph.dfs_stack(0);
	}
	
}
