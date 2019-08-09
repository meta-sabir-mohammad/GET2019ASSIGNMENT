package Assignment6A;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class GraphTest {

	@Test
	public void testIsConnected() {
		Graph graph = new Graph(2);
		graph.addEdge(0, 1);
		assertTrue(graph.isConnected());
		
	}

	@Test
	public void testAllReachableVertices() {
		Graph graph = new Graph(3);
		graph.addEdge(0, 1);
		ArrayList<Integer> expected = new ArrayList<Integer>();
		ArrayList<Integer> actual = graph.allReachableVertices(0);
		for(int index =0; index < expected.size(); index++){
			assertEquals(expected.get(index),actual.get(index));
		}
		
	}
	
	@Test
	public void testMinimumSpanningTree() {
		
	}

	@Test
	public void testShortestPath() {
		
	}

}
