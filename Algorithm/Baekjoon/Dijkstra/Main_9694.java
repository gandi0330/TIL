import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9694 {

	
	public static class Vertex implements Comparable<Vertex>{
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Vertex>> list = new ArrayList<>();
			for(int i=0;i<M;i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				list.get(x).add(new Vertex(y,z));
				list.get(y).add(new Vertex(x,z));
			}
			
			int[][] distance = new int[M][2];
			boolean[] visited = new boolean[M];
			
			for(int i=0;i<M;i++) {
				distance[i] = new int[] {Integer.MAX_VALUE, -1};
			}
			
			int start = 0;
			distance[start][0] = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(start,distance[start][0]));
			
			Stack<Integer> answer = new Stack<>();
			
			while(!pq.isEmpty()) {
				int current = pq.poll().no;
				
				if(visited[current]) continue;
				visited[current] = true;
				
				if(current == M-1) {
					while(current != -1) {
						answer.push(current);
						current = distance[current][1];
					}
					break;
				}
				
				for(Vertex v : list.get(current)) {
					if(distance[v.no][0] > distance[current][0] + v.w) {
						distance[v.no][0] = distance[current][0] + v.w;
						distance[v.no][1] = current;
						pq.offer(new Vertex(v.no,distance[v.no][0]));
					}
				}
			}
			
			
			sb.append("Case #"+tc+": ");
			if(answer.size() > 0) {
				while(!answer.isEmpty()) sb.append(answer.pop() + " ");
				
				sb.setLength(sb.length()-1);
				
			}
			
			else {
				sb.append(-1);
			}
			sb.append("\n");
			
			
		}
		System.out.print(sb);
	}

}
