package visualization;

import java.util.ArrayList;

//a class to enable the drawing of directed graphs
public class Node {

	private String key;
	private Node parent;
	private ArrayList<Node> edges;
	private int[] rgb = new int[3];
	private float lat;
	private float longt;
	private int complexity;
	private int depth;

	// node constructor for constructing a parentless node
	public Node(String name) {
		this.parent = null;
		this.key = name;
		this.edges = new ArrayList<Node>();

	}

	// constructor for constructing a node with a parent
	public Node(String name, Node nodeParent) {
		this.key = name;
		this.edges = new ArrayList<Node>();
		this.parent = nodeParent;

	}

	public int[] getColor() {
		return rgb;
	}

	public void setColor(int[] c) {
		this.rgb = c;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	// getter method for the node key (in our case the name of the developer)
	public String getName() {
		return this.key;
	}

	// gets the Node at index i in the arraylist of edges
	public Node getNode(int i) {
		return edges.get(i);

	}

	// returns the edges associated with the node
	public ArrayList getEdges() {
		return this.edges;

	}

	// adds an edge to the node
	public void addEdge(Node node) {
		this.edges.add(node);

	}

	public float getLat() {
		return this.lat;
	}

	public float getLongt() {
		return this.longt;
	}

	public void setLat(float newLat) {
		this.lat = newLat;

	}

	public void setLongt(float newLongt) {
		this.longt = newLongt;
	}

	public void setComplexity(int complex) {
		this.complexity = complex;

	}

	public int getComplexity() {
		return this.complexity;
	}
	
	public int getDepth(){
		return this.depth;
	}
	
	public void setDepth(int newDepth){
		this.depth = newDepth;
	}

	// returns the number of children that a node and its sub nodes have
	// including its self
	public int getNumNodes() {
		int accumulator = 0;
		int tempNum;

		if (this.edges.size() == 0) {
			return 1;
		} else {
			for (int i = 0; i < this.edges.size(); i++) {
				tempNum = this.edges.get(i).getNumNodes();
				accumulator = accumulator + tempNum;
			}
			return accumulator;
		}
	}

}
