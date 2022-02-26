import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485 {
	
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	// 정점 번호와 해당 번호로 갈 때의 가중치
	public static class Vertex implements Comparable<Vertex>{
		int no;
		int w;
		
		Vertex(int no, int w ){
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n;
		int tc=0;
		loop : while((n = Integer.parseInt(br.readLine())) != 0) {
			
			// ===================== 입력 ===========================
			tc++;
			int[][] mat = new int[n][n];
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 인접리스트 생성
			ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
			for(int i=0;i<n*n;i++) list.add(new ArrayList<Vertex>());
			
			// 동굴 각 칸을 정점으로 두고 해당 정점으로부터 네 방향을 간선으로 연결하고 가중치를 설정
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int k=0;k<4;k++) {
						int nextI = i+deltas[k][0];
						int nextJ = j+deltas[k][1];
						
						if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;
						
						// 각 정점의 번호를 행*n + 열 로 매긴다 (ex 행렬 크기가 10*10일 때 : 1행 1열 = 0, 2행 3열 = 12) 
						list.get(i*n+j).add(new Vertex(nextI*n+nextJ, mat[nextI][nextJ]));
					}
				}
			}
			
			
			boolean[] visited = new boolean[n*n]; // 최소거리가 되었는지 확인
			int[] distance = new int[n*n]; // 시작 점부터 각 정점의 최소거리
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			int start = 0;
			distance[start] = mat[0][0]; // 0,0 에서 시작
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>(); 
			pq.offer(new Vertex(start,distance[start]));
			
			
			while(!pq.isEmpty()) {
				int current = pq.poll().no;
				
				if(visited[current]) continue;
				
				// 동굴을 탈출하면 시작점부터 끝 점까지의 최소 거리 출력
				if(current == n*n-1) {
					sb.append("Problem " + tc+": " + distance[n*n-1]+"\n");
					continue loop;
				}
				
				for(Vertex v : list.get(current)) {
					if(distance[v.no] > distance[current] + v.w) {
						distance[v.no] = distance[current] + v.w;
						pq.offer(new Vertex(v.no,distance[v.no]));
					}
				}
				
			}
		
		}
		
		System.out.println(sb);
	}

}
