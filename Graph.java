import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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

	private ArrayList<Vertex> vertices;

	public Graph(int v) {
		this.vertices = new ArrayList<>(v);
		for(int i=0;i<=v;i++) {
			this.vertices.add(new Vertex(i));
		}
	}

	public void addEdge(int u, int v) {
		this.vertices.get(u).addNeighbour(v);
		this.vertices.get(v).addNeighbour(u);
	}

	public int getChromaticNumber() {
		int chromaticNumber = -1;
		
		vertices.sort((l1, l2)->l2.getVertexDegree() - l1.getVertexDegree());
		
		HashMap<Integer, Integer> vertexColorIdx = new HashMap<>();
		
		for(int i=0;i<vertices.size();i++) {
		
			Vertex v = vertices.get(i);
		
			if(vertexColorIdx.containsKey(v.getNode())) {
				continue;
			}else {
				vertexColorIdx.put(v.getNode(), i);
				for(int j=i+1;j<vertices.size();j++) {
					Vertex tmp = vertices.get(i);
					Vertex tmp1 = vertices.get(j);
					if (!(tmp.hasNeighbour(tmp1.getNode())) && !(vertexColorIdx.containsKey(tmp1.getNode()))){
						vertexColorIdx.put(tmp1.getNode(), i);
					}
				}
			}
		}
		
		for (HashMap.Entry<Integer, Integer> entry : vertexColorIdx.entrySet()){
			int value = entry.getValue();
			if(value>chromaticNumber) {
				chromaticNumber = value;
			}
		}
		chromaticNumber++;

		return chromaticNumber;
	}
}