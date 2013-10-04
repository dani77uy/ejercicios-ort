package util;

import java.util.ArrayList;

public class GraphNode implements Comparable<GraphNode> {

	private static int nodeCount = 0;

	private ArrayList<Edge> outGoingEdges = new ArrayList<Edge>();
	private String val;
	private Integer ID;
	private boolean visited;
	private Integer distance = GraphConstants.INFINITY;

	public GraphNode(String value) {
		this.init(value);
	}

	public GraphNode() {
		this.init("");
	}

	private void init(String nodeVal) {
		this.val = nodeVal;
		this.ID = GraphNode.nodeCount++;
		this.visited = false;
	}

	public void setVisited(boolean visited) {
		System.out.println("Visited" + this.val);
		this.visited = visited;
	}

	public void addOutgoingEdge(GraphNode node, Integer cost) {
		this.outGoingEdges.add(new Edge(node, cost));
	}

	public ArrayList<Edge> getOutGoingEdges() {
		return outGoingEdges;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Integer getID() {
		return ID;
	}

	public int compareTo(GraphNode arg0) {
		return this.distance.compareTo(arg0.getDistance());
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	final class Edge {

		private GraphNode node;
		private Integer cost;

		public Edge(GraphNode nodeTo, Integer cost) {
			this.node = nodeTo;
			this.cost = cost;
		}


		public GraphNode getNode() {
			return node;
		}


		public Integer getCost() {
			return cost;
		}
	}
	
}
