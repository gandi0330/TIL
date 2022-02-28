import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13549 {
	static int N,K;
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int w;
		
		Vertex(int no, int w){
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
		
		for(int i=0;i<=100000;i++) {
			list.add(new ArrayList<>());
			if(i-1 >= 0) list.get(i).add(new Vertex(i-1,1));
			if(i+1 <= 100000) list.get(i).add(new Vertex(i+1,1));
			if(i*2 <= 100000 && i!= 0) list.get(i).add(new Vertex(i*2,0));
		}
		
		int[] distance = new int[100001];
		boolean[] visited = new boolean[100001];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int start = N;
		
		distance[start] = 0;
		
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start,0));
		
		while(!pq.isEmpty()) {
			int current = pq.poll().no;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			if(current == K) {
				System.out.println(distance[current]);
				break;
			}
			
			for(Vertex v : list.get(current)) {
				
				if(distance[v.no]> distance[current] + v.w ) {
					distance[v.no]= distance[current] + v.w;
					pq.offer(new Vertex(v.no,distance[v.no]));
				}
			}
			
		}
		
	}

		
	
}
