import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {

	
	
	// 상하좌우로 바이러스가 퍼져나감
	// 0은 빈칸 , 1은 벽, 2는 바이러스
	// 벽을 3개 세울 수 있으며 꼭 세워야됨
	// 바이러스가 퍼질 수 없는 곳 == 안전영역
	// 안전영역 크기의 최댓값 구하기

	// 크기는 최대 8 * 8 
	// 그렇다면 벽이 아닌 곳(0)의 최대 개수는 64개
	// 64개 빈 칸 중 벽을 3개 설치할 경우의 수 == 64 C 3 => 약 4만번
	// 벽 3개 선택 후 전체 bfs 혹은 dfs ( 최대 함수 호출 개수 -> 64 )
	// 2.5백만 연산 -> 0.25초
	
	static int N,M;
	static int mat[][];
	static List<int[]> blank;
	static int numbers[];
	static List<int[]> virus;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int maxSafezone;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// =================== 입력 =====================
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		
		blank = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 0) {
					blank.add(new int[] {i,j});
				}
				if(mat[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		
		numbers = new int[3];
		maxSafezone = 0;
		// =================== 솔루션 =======================
		
		combination(0,0);
		
		System.out.println(maxSafezone);
		
	}

	
	
	public static void combination(int cnt, int start) {
		
		if(cnt == 3) { // 벽 선택 완료
			int temp[][] = new int[N][M];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					temp[i][j] = mat[i][j];
				}
			}
			
			for(int i=0;i<3;i++) {
				int data[] = blank.get(numbers[i]);
				temp[data[0]][data[1]] = 1;
			}
			
			boolean[][] visited = new boolean[N][M];
			bfs(temp, visited);
			
			
			return;
		}
		
		for(int i=start; i<blank.size();i++) {
			numbers[cnt] = i;
			combination(cnt+1,i+1);
		}
	}
	
	public static void bfs(int[][] temp, boolean[][] visited) {
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0;i<virus.size();i++) {
			int[] virusData = virus.get(i);
			que.add(virusData);
			visited[virusData[0]][virusData[1]] = true;
		}
		
		while(!que.isEmpty()) {
			int[] virusData = que.poll();
			
			for(int i=0;i<4;i++) {
				int nextR = virusData[0] + deltas[i][0];
				int nextC = virusData[1] + deltas[i][1];
				
				// 다음 탐색할 칸이 범위를 벗어났거나 이미 방문했거나 빈칸이 아니면 넘어간다
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || visited[nextR][nextC] || temp[nextR][nextC] != 0 ) continue;
				
				temp[nextR][nextC] = 2;
				visited[nextR][nextC] = true;
				que.add(new int[] {nextR,nextC});
			}
		}
		
		int cnt = 0;
				
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
				
		maxSafezone = Math.max(cnt, maxSafezone);
		
		
	}
}
