package Assignment6A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * This class represent graph and contain method related to it
 * @author Sabir
 *
 */
public class Graph implements IGraph {

	private LinkedList<Integer>[] vertices;
	private int numberOfVertices;
	
	@SuppressWarnings("unchecked")
	public Graph(int numberOfVertices) {
		
		this.numberOfVertices = numberOfVertices;
		this.vertices =(LinkedList<Integer>[]) new LinkedList[numberOfVertices];
		for(int vertex =0;vertex < this.numberOfVertices;vertex++) {
			this.vertices[vertex] = new LinkedList<Integer>();
		}
	}
	
	public boolean addEdge(int startVertex, int endVertex){
		
		this.vertices[startVertex].add(endVertex);
		this.vertices[endVertex].add(startVertex);
		
		return true;
	}
	
	/**
	 * This method check if the graph is connected or not
	 * @return true if graph is connected else false
	 */
	@Override
	public boolean isConnected() {
		
		int[] visitedVertices = new int[this.numberOfVertices]; 
		dfsOfGraph(0,visitedVertices); 

		for(int visitedVertexIndex =0; visitedVertexIndex < this.numberOfVertices; visitedVertexIndex++) {
			if(visitedVertices[visitedVertexIndex] == 0) { return false; }
		}
		return true;
	}

	private int[] dfsOfGraph(int vertex, int visitedVertices[]) { 

		Stack<Integer> vertexStack = new Stack<>(); 
		vertexStack.push(vertex); 
		while(vertexStack.empty() == false) 
		{  
			vertex = vertexStack.peek(); 
			vertexStack.pop(); 
			if(visitedVertices[vertex] == 0) { 
				visitedVertices[vertex] = 1;
			} 
			Iterator<Integer> verticesIterator = this.vertices[vertex].iterator(); 

			while (verticesIterator.hasNext()) { 
				vertex = verticesIterator.next(); 
				if(visitedVertices[vertex] == 0) 
					vertexStack.push(vertex); 
			} 
		} 
		return visitedVertices;
	} 
	
	/**
	 * This method find all reachable vertices from a given a vertex in graph
	 * @return ArrayList containing list of vertices which are reachable 
	 */
	@Override
	public ArrayList<Integer> allReachableVertices(int vertex) {

		int[] visitedVertices = new int[this.numberOfVertices]; 
		dfsOfGraph(vertex,visitedVertices); 
		ArrayList<Integer> reachableVertices = new ArrayList<Integer>();
		for(int visitedVertex : visitedVertices){
			reachableVertices.add(visitedVertex);
		}
		return reachableVertices;
	}

	/**
	 * This method find the minimum spanning tree in the graph
	 * @return ArrayList of ArrayList containing details about the edges between vertices that create minimum spanning tree
	 */
	@Override
	public ArrayList<Integer>[] minimumSpanningTree() {

		return null;
	}

	/**
	 * This method find the shorted path between given two vertices in the graph
	 * @return list of vertices which create shortest path
	 */
	@Override
	public ArrayList<Integer> shortestPath(int startingVerted, int endingVertex) {

		return null;
	}

}
