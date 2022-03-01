import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {

	public static class Vertex implements Comparable<Vertex>{
		int no;
		int w;
		
		Vertex(int no, int w){
			super();
			this.no  = no;
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
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(new Vertex(v2,w));
			list.get(v2).add(new Vertex(v1,w));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int[][] numLists = {{1,n1,n2,N},{1,n2,n1,N}};
		
		int minDistance = Integer.MAX_VALUE;
		boolean hasNotPath = false;
		loop : for(int[] numList : numLists) {
			int d = 0;
			for(int i=0;i<3;i++) {
				int start = numList[i];
				int end = numList[i+1];
				
				int[] distance = new int[N+1];
				Arrays.fill(distance, Integer.MAX_VALUE);
				
				boolean[] visited = new boolean[N+1];
				
				distance[start] = 0;
				
				PriorityQueue<Vertex> pq = new PriorityQueue<>();
				pq.offer(new Vertex(start, distance[start]));
				
				while(!pq.isEmpty()) {
					int current = pq.poll().no;
					
					if(visited[current]) continue;
					
					if(current == end) {
						break;
					}
					
					for(Vertex v : list.get(current)) {
						if(distance[v.no] > distance[current] + v.w ) {
							distance[v.no] = distance[current] + v.w;
							pq.offer(new Vertex(v.no,distance[v.no]));
						}
					}
				}
				
				if(distance[end] != Integer.MAX_VALUE) {
					d += distance[end];
				}
				else {
					hasNotPath = true;
					continue loop;
				}
			}
			
			minDistance = Math.min(minDistance, d);
		}
		
		if(hasNotPath) System.out.println(-1);
		else System.out.println(minDistance);
		
		
	}

}
