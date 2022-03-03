import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11779 {

	
	public static class Vertex implements Comparable<Vertex>{
		int no;
		int w;
		
		Vertex(int no,int w){
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.w - o.w;
		}
		
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(new Vertex(v2,cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[n+1];
		boolean[] visited = new boolean[n+1];
		int[] preVertex = new int[n+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(preVertex, -1);
		
		distance[start] = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(start,distance[start]));
		
		while(!pq.isEmpty()) {
			int current = pq.poll().no;
			
			if(visited[current]) continue;
			visited[current] = true;
			
			
			if(current == end) break;
			
			for(Vertex v : list.get(current)) {
				if(distance[v.no] > distance[current] + v.w ) {
					distance[v.no] = distance[current] + v.w;
					preVertex[v.no]= current;
					pq.offer(new Vertex(v.no, distance[v.no]));
				}
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int city = end;
		
		while(city != -1) {
			stack.push(city);
			city = preVertex[city];
		}
		
		StringBuilder sb = new StringBuilder();
		int size = stack.size();
		
		sb.append(distance[end]).append("\n");
		sb.append(size).append("\n");
		for(int i=0;i<size;i++) {
			sb.append(stack.pop()).append(" ");
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
		
	}

}
