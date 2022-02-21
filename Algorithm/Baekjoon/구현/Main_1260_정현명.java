import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_정현명 {

	
	static int N,M,V;
	static boolean[][] mat;
	static boolean visitedDfs[];
	static boolean visitedBfs[];
	static StringBuilder sb1;
	static StringBuilder sb2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		
		mat = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			mat[v1][v2] = true;
			mat[v2][v1] = true;
		}
		
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		
		dfs(V);
		
		sb1.setLength(sb1.length()-1);
		System.out.println(sb1);
		
		bfs(V);
		
		sb2.setLength(sb2.length()-1);
		System.out.println(sb2);
		
	}
	
	public static void dfs(int v) {
		visitedDfs[v] = true;
		sb1.append(v).append(" ");
		
		for(int i=1;i<=N;i++) {
			if(mat[v][i] && !visitedDfs[i]) dfs(i);
		}
	}
	
	public static void bfs(int v) {
		visitedBfs[v] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(v);
		
		while(!queue.isEmpty()){
			int vor = queue.poll();
			sb2.append(vor).append(" ");
			for(int i=1;i<=N;i++) {
				if(mat[vor][i] && !visitedBfs[i]) {
					visitedBfs[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
