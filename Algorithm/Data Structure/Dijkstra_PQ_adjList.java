import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PQ_adjList {

	public static class Vertex implements Comparable<Vertex>{
		int no;
		int weight;
		
		Vertex(int no, int weight){
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<ArrayList<Vertex>>();
		
		int distance[] = new int[N];
		for(int i=0;i<N;i++) {
			distance[i] = Integer.MAX_VALUE;
			list.add(new ArrayList<Vertex>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(new Vertex(v2,w));
			
		}
		
		boolean[] visited = new boolean[N];
		
		int start = 0;
		distance[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0)); // pq에 들어가는 Vertex의 두 번째 인자는 최소 거리 (distance로 사용)
		
		while(!pq.isEmpty()) {
			
			int current = pq.poll().no;
			
			if(visited[current]) continue;
			
			visited[current] = true;
			
			for(Vertex nextV : list.get(current)) {
				if(distance[nextV.no] > distance[current] + nextV.weight ) {
					distance[nextV.no] = distance[current] + nextV.weight;
					pq.add(new Vertex(nextV.no,distance[nextV.no]));
				}
			}
		}
		
		System.out.println(Arrays.toString(distance));
		
		
	}

}
