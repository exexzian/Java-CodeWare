package com.soft.dev;

public class DetectCycleGraph {
	
	
	
	
	// Driver Code
    public static void main(String[] args)
    {
 
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
       // g.addEdge(2, 0);
        g.addEdge(3, 4);
        g.addEdge(5, 2);
        g.addEdge(4, 5);
 
        System.out.println("The Breadth First Traversal of the graph is as follows :");
		g.bfs(0);
		
		System.out.println();
        if (g.isCycle(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
