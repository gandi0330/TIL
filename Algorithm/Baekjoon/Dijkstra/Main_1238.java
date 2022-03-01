import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238 {
	
	static int N,M,X;
	static int maxTime;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int [][]adjMatrix = new int[N+1][N+1];
		int [][]adjMatrixRev = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			adjMatrix[v1][v2] = t;
			adjMatrixRev[v2][v1] = t;
		}
		
		maxTime = 0;
		
		
		
		int[] d1 = dijkstra(adjMatrix);
		int[] d2 = dijkstra(adjMatrixRev);
		
		for(int i=1;i<=N;i++) {
			maxTime = Math.max(maxTime, d1[i]+d2[i]);
		}
		
		
		System.out.println(maxTime);
	}
	
	
	public static int[] dijkstra(int[][] adjMat) {
		int start = X;
		
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		
		for(int i=0;i<N;i++) {
			int current = 0;
			int min = Integer.MAX_VALUE;
			
			for(int j=1;j<=N;j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			
			
			visited[current] = true;
			
			
			for(int j=1;j<=N;j++) {
				if(!visited[j] && adjMat[current][j] != 0 &&  distance[j] > distance[current] + adjMat[current][j]) {
					distance[j] = distance[current] + adjMat[current][j];
					
				}
				
			}
		}
		
		return distance;
	}
}
