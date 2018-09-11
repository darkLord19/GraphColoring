import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.File; 

public class GreedyGraphColoring {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(System.out);
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

		int chromaticNumber = g.getChromaticNumber();

		pw.println("Chromatic Number of given graph is: "+chromaticNumber);

		pw.close();

	}
} 