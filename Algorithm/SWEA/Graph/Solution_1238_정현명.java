import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_정현명 {

	static int lastMax;
	static boolean visited[];
	static boolean[][] mat;
	static int level;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			mat = new boolean[101][101]; // 인접행렬 생성
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			// 인접행렬에 방향있는 그래프 데이터 입력
			for(int i=0;i<dataLen/2;i++) {
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				mat[from][to] = true;
			}
			lastMax = 0; // 가장 마지막 level 중 가장 큰 값
			bfs(start);
			sb.append("#").append(tc).append(" ").append(lastMax).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int v) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {v,1}); // 번호와 레벨을 큐에 저장
		visited[v] = true;
		level = 1; // 현재 레벨 1부터 시작
		while(!queue.isEmpty()) {
			int[] readInfo = queue.poll();
			if(level == readInfo[1]) { // 레벨이 같으면 같은 레벨의 값 중 가장 큰 값을 저장
				lastMax = Math.max(lastMax, readInfo[0]);
			}
			else { // 다음 레벨로 진입 시 lastMax를 초기화
				level++;
				lastMax = readInfo[0];
			}
			for(int i=1;i<=100;i++) {
				if(mat[readInfo[0]][i] && !visited[i]) {
					visited[i] = true;
					queue.add(new int[]{i,readInfo[1]+1});
				}
			}
		}
	}

}
