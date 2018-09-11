import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Graph {

	static class Vertex implements Comparable {
		private int node;
		private ArrayList<Integer> neighbours;

		public Vertex(int n) {
			this.node = n;
			this.neighbours = new ArrayList<>(10);
		}

		public void addNeighbour(int v) {
			this.neighbours.add(v);
		}

		@Override
		public int compareTo(Object o) {
			Vertex v = (Vertex) o;
			int x = this.neighbours.size();
			int y = v.neighbours.size();
			return  x < y ? 1 : x == y ? 0 : -1;
		}
	}

	private ArrayList<Vertex> vertices;

	public Graph(int v) {
		this.vertices = new ArrayList<>(v+1);
	}

	public void addEdge(int u, int v) {
		this.vertices.add(new vertex(u));
		this.vertices.get(v).addNeighbour(u);
	}

	public int getChromaticNumber(Graph g) {
		int chromaticNumber = 0;
		Collections.sort(g.vertices);
		HashMap<Integer, Integer> vertexColorIdx = new HashMap<>();
		for(int i=0;i<vertices.size();i++) {
			Vertex v = vertices.get(i);
			if(vertexColorIdx.containsKey(v.node)) {
				continue;
			}else {
				vertexColorIdx.put(v.node, i);
				for(int j=i+1;j<vertices.size();j++) {
					Vertex tmp = vertices.get(i);
					Vertex tmp1 = vertices.get(j);
					if(!(tmp.neighbours.contains(tmp1.node)) && !(vertexColorIdx.containsKey(tmp1.node))) {
						vertexColorIdx.put(tmp1.node, i);
					}
				}
			}
		}
		System.out.println(vertexColorIdx);
		return 0;
	}
}