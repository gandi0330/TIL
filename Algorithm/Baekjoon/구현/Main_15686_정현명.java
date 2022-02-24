import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686_정현명 {

	static int N,M;
	static List<int[]> chickens;
	static int numbers[];
	static int chickenDistance;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int houseCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		chickenDistance = Integer.MAX_VALUE;
		
		chickens = new ArrayList<int[]>(); 
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int info = Integer.parseInt(st.nextToken());
				
				map[i][j] = info;
				
				if(info == 2) chickens.add(new int[] {i,j});
				if(info == 1) houseCnt++;
			}
		}
		
		numbers = new int[M]; // 치킨집을 고를 번호
		combination(0,0);
		
		System.out.println(chickenDistance);
		
		
	}
	
	public static void combination(int start, int cnt) {
		if(cnt == M) {
			visited = new boolean[N][N];
			bfs();
			return;
		}
		
		for(int i=start;i<chickens.size();i++) { // 조합으로 치킨집을 선택
			numbers[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	
	public static void bfs() {
		int subHouseCnt = houseCnt;
		Queue<int[]> que = new LinkedList<int[]>();
		
		int distance = 0;
		
		for(int i : numbers) {
			int[] chicken  = chickens.get(i);
			que.add(new int[] {chicken[0],chicken[1],1});
			visited[chicken[0]][chicken[1]] = true;
		}
		
		while(!que.isEmpty() && subHouseCnt > 0) {
			int[] data = que.poll();
			
			int r = data[0];
			int c = data[1];
			int level = data[2];
			
			
			
			for(int i=0;i<4;i++) {
				int nextR = r + deltas[i][0];
				int nextC = c + deltas[i][1];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visited[nextR][nextC]) continue;
				
				visited[nextR][nextC] = true;
				que.add(new int[] {nextR,nextC,level+1});
				
				if(map[nextR][nextC] == 1) {
					subHouseCnt--;
					distance += level;
				}
			}
			
			
		}
		
		chickenDistance = chickenDistance > distance ? distance : chickenDistance;
		
		
	}

}
