import java.util.HashMap;

public class Greedy {

	private Graph graph;
	
	public Greedy(Graph g) {
		graph = g;
	}
	
	public int getChromaticGreedy() {
		int chromaticNumber = -1;
		
		this.graph.getVertices().sort((l1, l2)->l2.getVertexDegree() - l1.getVertexDegree());
		
		HashMap<Integer, Integer> vertexColorIdx = new HashMap<>();
		
		int size = this.graph.getVertices().size();
		for(int i=0;i<size;i++) {
		
			Vertex v = this.graph.getVertices().get(i);

			if(vertexColorIdx.containsKey(v.getNode())) {
				continue;
			}else {
				vertexColorIdx.put(v.getNode(), i);
				for(int j=i+1;j<size;j++) {
					Vertex tmp = this.graph.getVertices().get(i);
					Vertex tmp1 = this.graph.getVertices().get(j);
					if (!(tmp.hasNeighbour(tmp1.getNode())) && !(vertexColorIdx.containsKey(tmp1.getNode()))){
						vertexColorIdx.put(tmp1.getNode(), i);
					}
				}
			}
		}

		// printColors(vertexColorIdx);
		
		for (HashMap.Entry<Integer, Integer> entry : vertexColorIdx.entrySet()){
			int value = entry.getValue();
			if(value>chromaticNumber) {
				chromaticNumber = value;
			}
		}
		chromaticNumber++;

		return chromaticNumber;
	}

	public void printColors(HashMap<Integer, Integer> map) {
		map.forEach((key, value) -> System.out.println(key+" "+value));
	}

}
