import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileReader; 
import java.io.FileNotFoundException; 

public class GreedyGraphColoring {

	public static void main(String[] args) {
		
		BufferedReader reader = null;
		PrintWriter pw = new PrintWriter(System.out);

		try {
			reader = new BufferedReader(new FileReader("input.txt"));	
		}catch(FileNotFoundException e) {
			pw.println("Please create input.txt file");
		}

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