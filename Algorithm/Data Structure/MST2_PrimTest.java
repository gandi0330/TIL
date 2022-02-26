import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST2_PrimTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] adjMat = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMat[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0;
		
		for(int c=0;c<N;c++) { // N개의 정점을 모두 연결
			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			//  
			for(int i=0;i<N;i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			// 선택된 정점을 신장트리에 포함시킴
			visited[minVertex] = true;
			result += min;
			
			// 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선 비용을 따져보고 최소값 갱신
			for(int i=0;i<N;i++) {
				if(!visited[i] && adjMat[minVertex][i] != 0 && minEdge[i] > adjMat[minVertex][i]) {
					minEdge[i] = adjMat[minVertex][i];
				}
			}
		}
		
		System.out.println(result);
	}

}
