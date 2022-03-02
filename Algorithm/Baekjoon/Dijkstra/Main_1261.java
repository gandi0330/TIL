import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {

	public static class Vertex implements Comparable<Vertex>{
		int no;
		int w;
		
		Vertex(int no, int w){
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}	

	}
	
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
		for(int i=0;i<N*M;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				int data = line.charAt(j) - '0';
				
				
				for(int k=0;k<4;k++) {
					int nextI = i+deltas[k][0];
					int nextJ = j+deltas[k][1];
					
					if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M) continue;
					if(data == 0) list.get(nextI*M + nextJ).add(new Vertex(i*M + j,0));
					else list.get(nextI*M + nextJ).add(new Vertex(i*M + j,1));
				}
			}
		}
		
		int[] distance = new int[N*M];
		boolean[] visited = new boolean[N*M];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int start = 0;
		distance[start] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start,distance[start]));
		
		while(!pq.isEmpty()) {
			int current = pq.poll().no;
			
			if(visited[current]) continue;
			
			if(current == N*M-1) {
				System.out.println(distance[current]);
				break;
			}
			
			for(Vertex v : list.get(current)) {
				if(distance[v.no] > distance[current] + v.w) {
					distance[v.no]= distance[current] + v.w;
					pq.offer(new Vertex(v.no,distance[v.no]));
				}
			}
		}
		
				
	}

}
