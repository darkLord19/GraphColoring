import java.util.ArrayList;

class Vertex {

	private int node;
	private ArrayList<Integer> neighbours;

	public Vertex(int n) {
		this.node = n;
		this.neighbours = new ArrayList<>();
	}

	public int getNode() {
		return this.node;
	}

	public void addNeighbour(int v) {
		this.neighbours.add(v);
	}

	public int getVertexDegree() {
		return this.neighbours.size();
	}

	public boolean hasNeighbour(int n) {
		return this.neighbours.contains(n);
	}

}
public class Graph {

	private int V;
	private ArrayList<Vertex> vertices;
	
	public Graph(int v) {
		this.V = v;
		this.vertices = new ArrayList<>(v);
		for(int i=0;i<=V;i++) {
			this.vertices.add(new Vertex(i));
		}
	}

	public int getVertexCount() {
		return this.V;
	}

	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}
	
	public void addEdge(int u, int v) {
		this.vertices.get(u).addNeighbour(v);
		this.vertices.get(v).addNeighbour(u);
	}
	
}