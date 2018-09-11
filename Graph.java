import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Graph {

	private int numOfVertices;
	private ArrayList<ArrayList<Integer>> vertices;

	public Graph(int v) {
		numOfVertices = v;
		this.vertices = new ArrayList<>(v+1);
	}

	public void addEdge(int u, int v) {
		this.vertices.get(u).add(v);
		this.vertices.get(v).add(u);
	}

	public int getChromaticNumber() {
		int chromaticNumber = 0;
		vertices.sort((l1, l2)->l2.size()-l1.size());
		HashMap<Integer, Integer> vertexColorIdx = new HashMap<>();
		for(int i=1;i<vertices.size();i++) {
			if(vertexColorIdx.containsKey(i)) {
				continue;
			}else {
				vertexColorIdx.put(i, i);
				for(int j=i+1;j<vertices.size();j++) {
					if(!(vertices.get(i).contains(i)) && !(vertexColorIdx.containsKey(j))) {
						vertexColorIdx.put(j, i);
					}
				}
			}
		}
		System.out.println(vertexColorIdx);
		return 0;
	}
}