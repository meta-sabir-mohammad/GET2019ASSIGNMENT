package Assignment6A;

import java.util.ArrayList;

public interface IGraph {

	/**
	 * This method check if the graph is connected or not
	 * @return true if graph is connected else false
	 */
	public boolean isConnected();

	/**
	 * This method find all reachable vertices from a given a vertex in graph
	 * @return ArrayList containing list of vertices which are reachable 
	 */
	public ArrayList<Integer> allReachableVertices(int vertex);

	/**
	 * This method find the minimum spanning tree in the graph
	 * @return ArrayList of ArrayList containing details about the edges between vertices that create minimum spanning tree
	 */
	public ArrayList<Integer>[] minimumSpanningTree();

	/**
	 * This method find the shorted path between given two vertices in the graph
	 * @return list of vertices which create shortest path
	 */
	public ArrayList<Integer> shortestPath(int startingVerted, int endingVertex);
}
