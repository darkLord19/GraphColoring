
public class Backtracking {
	private Graph graph;
	private int[] color;
	
	public Backtracking(Graph g) {
		this.graph = g;
		this.color = new int[g.getVertexCount()+1];
		for(int i=0;i<=g.getVertexCount();i++) {
			color[i] = 0;
		}
	}
	
	//checks if the current color c is safe for vertex v
	boolean isSafe(int v, int c) {
		int vertices = this.graph.getVertexCount();
		for(int i=1;i<=vertices;i++) {
			if(this.graph.getVertices().get(i).hasNeighbour(v) && color[i] == c ) {
				return false;
			}
		}
		return true;
	}

	void setColors(int v, int C) {
		for(int c=1; c<=C; c++) {
			if(isSafe(v, c)) {
				color[v] = c;
				if(v+1 <= this.graph.getVertexCount()) {
					setColors(v+1, C);
				}
				else return;
			}
		}
	}
	int getChromaticNumber() {
		boolean flag = true;
		int i;
		for(i=1;i<=5;i++) {//using 5-colourable theorem
			flag = true;
			setColors(1, i);
			int vertices = this.graph.getVertexCount();
			for(int j=1;j<=vertices;j++ ) {
				if(color[j] == 0) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				//printcolors();
				break;
			}
		}
		return i;
	}
	void printcolors() {
		System.out.println("Vertex\tColor");
		int vertices = this.graph.getVertexCount();
		for(int i=1;i<=vertices;i++) {
			System.out.println( i+"\t"+ color[i]);
		}
	}
}
