import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1976 {

	static int[][] mat;
	static int N,M;
	static boolean visited[];
	static int citis[] ;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		mat = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		citis = new int[M];
		for(int i=0;i<M;i++) {
			citis[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(citis[0]);
		
		boolean allPass =  true;
		
		for(int i=0;i<M;i++) {
			if(visited[citis[i]]) continue;
			allPass = false;
			break;
		}
		
		
		if(allPass) System.out.println("YES");
		else System.out.println("NO");
	}
	
	
	public static void dfs(int node) {
		visited[node] = true;
		for(int i=1;i<=N;i++) {
			if(mat[node][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
