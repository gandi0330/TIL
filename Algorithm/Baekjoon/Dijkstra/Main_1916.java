import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {

	
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Vertex>());
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(new Vertex(v2,cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start,distance[start]));
		
		while(!pq.isEmpty()) {
			int current = pq.poll().no;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			if(current == end) {
				System.out.println(distance[current]);
				break;
			}
			
			for(Vertex v : list.get(current)) {
				if(distance[v.no] > distance[current] + v.w) {
					distance[v.no] = distance[current] + v.w;
					pq.offer(new Vertex(v.no, distance[v.no]));
				}
			}
		}
		
		
	}

}
