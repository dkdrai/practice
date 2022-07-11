package neetcode.graphs;

public class GraphMatrix {


	
	static char graph[][] = new char[5][5];

	public static void main(String[] args) {
		addEdge(0,3);
		addEdge(1,2);
		addEdge(1,3);
		addEdge(2,1);
		addEdge(2,4);
		addEdge(3,1);
		addEdge(3,0);
		addEdge(4,2);
		print();

	}
	public static void initialize() {
		for(int i  =0; i< graph.length; i++) {
			for(int j =0; j< graph[0].length; j++) {
					graph[i][j]  = 0;
			}
		}
	}
	public static void addEdge(int start, int end) {
		graph[start][end] = 1;
	}
	
	public static void print() {
		for(int i  =0; i< graph.length; i++) {
			for(int j =0; j< graph[0].length; j++) {
					System.out.print(" "+graph[i][j]);
			}
			System.out.println();
		}
	}

}
