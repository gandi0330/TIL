import java.util.Arrays;
import java.util.Scanner;

// 다익스트라는 양의 가중치를 가지는 무,유향 그래프에서 시작점으로부터 모든 정점으로 가는 가장 짧은 경로를 찾는 알고리즘
public class Dijkstra_Practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] mat = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		
		int[] distance = new int[n];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[n];
		
		int start = 0;
		distance[start] = 0;
		
		
		for(int i=0;i<n;i++) {
			
			// 1. 가장 거리가 짧으면서 방문하지 않았던 정점 찾기
			int min = Integer.MAX_VALUE, current = 0;
			
			for(int j=0;j<n;j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			
			// 2. 가장 가까운 정점 찾은 후 방문처리 
			visited[current] = true;
			
			// 3. 해당 정점으로부터 갈 수 있는 정점에 대해 짧은 거리를 갱신
			for(int j=0;j<n;j++) {
				if(!visited[j] && mat[current][j] > 0 && distance[j] > distance[current] + mat[current][j]) {
					distance[j] = distance[current] + mat[current][j];
				}
			}
			
			
		}
		
		
		System.out.println(Arrays.toString(distance));
		
	}
		
}
