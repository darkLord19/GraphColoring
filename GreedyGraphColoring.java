import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GreedyGraphColoring {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer inp = null;
		
		try {
			inp = new StringTokenizer(reader.readLine());	
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		int vertices = Integer.parseInt(inp.nextToken());
		int edges = Integer.parseInt(inp.nextToken());

		Graph g = new Graph(vertices);

		while(edges-->0) {
			
			try {
				inp = new StringTokenizer(reader.readLine());
			}catch(IOException e) {
				System.out.println(e.toString());
			}

			int u = Integer.parseInt(inp.nextToken());
			int v = Integer.parseInt(inp.nextToken());
			g.addEdge(u,v);
		
		}

		int chromaticNumber = g.getChromaticNumber(g);

	}
} 