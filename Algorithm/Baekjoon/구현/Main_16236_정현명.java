import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_정현명 {

	static int N;
	static int[][] mat;
	static int t;
	static boolean visited[][];
	static int deltas[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int sharkSize;
	static int eatFish;
	static int minLevel;
	static int babySharkR, babySharkC;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// =================== 입력  ======================
		N = Integer.parseInt(br.readLine());
		
		mat = new int [N][N];  // 맵 정보
		visited = new boolean[N][N]; // bfs 탐색을 위한 방문정보
		babySharkR = 0; // 현재 아기 상어의 행 좌표
		babySharkC = 0; // 현재 아기 상어의 열 좌표
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j] == 9) { // 아기 상어를 찾으면 해당 좌표를 저장하고 맵 정보에서 아기 상어 위치를 0으로 지운다
					babySharkR = i;
					babySharkC = j;
					mat[i][j] = 0;
				}
				
			}
		}
		
		
		sharkSize = 2; // 초기 아기상어 크기
		t = 0; // 물고기 잡아먹을 수 있는 시간
		minLevel = 0; // bfs 탐색 거리
		eatFish = 0; // 먹은 물고기 양
		
		// ================== 솔루션 ========================
		bfs(new int[] {babySharkR, babySharkC, 0}); // 현재 아기상어 위치에서 가장 가까우면서 위, 왼쪽에 있는 물고기 먹기
		
		// ================== 출력 =========================
		System.out.println(t);
	}
	
	
	
	public static void bfs(int[] info) {
//		System.out.println("r : " + babySharkR + " c : " + babySharkC + " t : " + t);
		Queue<int[]> que = new LinkedList<>();
		visited[info[0]][info[1]] = true;
		que.offer(info);
		
		boolean isNext = false; // 더 이상 먹을 물고기가 없으면 false, 있으면 true
		List<int[]> list = new ArrayList<>(); // 가장 가까운 물고기들의 좌표 리스트
		
		while(!que.isEmpty()) {
			int[] data = que.poll(); // 행, 열, 아기상어 위치로부터의 거리
			int r = data[0];
			int c = data[1];
			int level = data[2];
			
			if(level != minLevel) { // 아기상어로부터의 거리가 늘었을 때 
				if(list.size() != 0) { // 가까운 물고기가 있으면 
					Collections.sort(list,new Comparator<int[]>() { // 물고기들을 행, 열 좌표로 정렬
						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[0] == o2[0] ?  o1[1] - o2[1] : o1[0] - o2[0];
						}
						
					});
					
					int[] fish = list.get(0);
					int fishR = fish[0];
					int fishC = fish[1];
					
					// 아기상어를 물고기로 이동
					babySharkR = fishR;
					babySharkC = fishC;
					
					// 냠냠
					eatFish++;
					
					// 물고기 없애고 해당 거리만큼 시간 증가
					mat[fishR][fishC] = 0;
					t += level;
					
					// 먹은 물고기가 아기상어 크기만큼 되었을 때 
					if(eatFish == sharkSize) {
						eatFish = 0; // 먹은 물고기 초기화
						sharkSize++; // 아기상어 크기 증가
					}
					
				
					visited = new boolean[N][N]; // bfs 방문 초기화
					minLevel = 0; // 이동거리 초기화
					isNext = true; // 다음 물고기를 찾으러 갑니다
					break;
					
				}
				else {
					minLevel = level;
				}
			}
			
			// 네 방향으로 탐색
			for(int i=0;i<4;i++) {
				int nextR = r + deltas[i][0];
				int nextC = c + deltas[i][1];
				
				// 범위를 벗어났거나 이미 방문했거나 아기 상어보다 큰 물고기가 있으면 넘어감
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visited[nextR][nextC] || mat[nextR][nextC] > sharkSize) continue;
				
				
				visited[nextR][nextC] = true; // 방문처리
				if(mat[nextR][nextC] > 0 && mat[nextR][nextC] < sharkSize) { // 먹을 수 있는 물고기를 만났을 때
					list.add(new int[] {nextR,nextC}); // 해당 물고기 좌표를 list에 저장
				}
				
				que.add(new int[] {nextR,nextC,level+1});
				
			}
		}
		
		if(isNext) { // 다시 가까운 물고기 탐색
			bfs(new int[] {babySharkR,babySharkC,0});
		}
	}

}
