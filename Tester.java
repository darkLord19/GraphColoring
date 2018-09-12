import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tester {

	public static void main(String args[]) {

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
		while(edges-- > 0) {
			try {
				inp = new StringTokenizer(reader.readLine());
			}catch(IOException e) {
				System.out.println(e.toString());
			}
			int u = Integer.parseInt(inp.nextToken());
			int v = Integer.parseInt(inp.nextToken());
			g.addEdge(u,v);
		}
		Backtracking bt = new Backtracking(g);
		System.out.println(bt.getChromaticNumber());
		Greedy gr = new Greedy(g);
		System.out.println(gr.getChromaticGreedy());

	}
}
