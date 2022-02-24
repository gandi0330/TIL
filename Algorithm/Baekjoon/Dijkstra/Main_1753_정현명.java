import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1753_정현명 {

	
	public static class Node{
		int v;
		int w;
		
		Node(int v, int w){
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		
		List<List<Node>> list = new ArrayList<>();
		for(int i=0;i<V+1;i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v,w));
			
		}
		
		
		
		int distance[] = new int[V+1]; // 출발지에서 해당 정점까지의 최소 비용 
		boolean visited[] = new boolean[V+1]; // 최소 비용 확정 여부
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		int start = K;
		distance[start] = 0; 
		
		
		for(int i=1;i<=V;i++) {
			
			// 연결된 정점 집합으로부터 가중치가 가장 짧은 정점 찾기
			int min = Integer.MAX_VALUE , current = 0;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			// 연결 완료
			visited[current] = true;
			
			// 새로운 정점으로부터 연결된 정점에 대해 최소 비용을 고려
			for(Node node : list.get(current)) {
				//  이전 경로보다 현재 정점으로 연결한 경로가 더 짧을 시 해당 경로의 비용으로 바꾼다
				if( distance[node.v] > distance[current] + node.w) {
					distance[node.v] = distance[current] + node.w;
				}
			}
			
			
		}
		
		for(int i=1;i<=V;i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else System.out.println(distance[i]);
		}
	}

}
