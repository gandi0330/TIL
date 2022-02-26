import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PriorityQueue {

	static class Vertex implements Comparable<Vertex>{
		int no;
		int distance;
		
		Vertex(int no, int distance){
			super();
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return  this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] mat = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[N];
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int start = 0;
		distance[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		pq.offer(new Vertex(start,distance[start]));
		
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			
			if(visited[v.no]) continue;
			
			visited[v.no] = true;
			
			for(int i=0;i<N;i++) {
				if(!visited[i] && mat[v.no][i] > 0 && distance[i] > v.distance + mat[v.no][i]) {
					distance[i] = v.distance + mat[v.no][i];
					pq.offer(new Vertex(i,distance[i]));
				}
			}
		}
		
		
		System.out.println(Arrays.toString(distance));
	}

}
