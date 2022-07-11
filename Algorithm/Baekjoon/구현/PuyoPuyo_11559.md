<h3>[알고리즘]  Java / 백준 / Puyo Puyo / 11559 </h3>

> 문제
> 

<br>

[문제 링크](https://www.acmicpc.net/problem/11559)

<br>

> 접근 방식
> 

<br>

문제의 요구는 다음과 같다.

1. 뿌요는 상하좌우로 연결되고 같은 색의 뿌요가 4개 이상 모이면 터진다.
2. 터질 수 있는 뿌요 그룹이 여러 개면 한번에 터진다
3. 터진 후 중력의 영향을 받아 아래로 떨어진다
4. 터진 후 뿌요들이 내려와 다시 터짐을 반복할 때 연속으로 몇 번 반복될 지를 구하라

먼저 1, 2번의 로직을 구현하면 다음과 같다

1. field에 뿌요정보를 입력받고 시뮬레이션 시작
2. field를 이중 포문으로 탐색하며 뿌요를 찾으면 같은 뿌요를 bfs로 탐색하고 탐색한 좌표들과 개수를 저장
    - 탐색한 개수가 4개 이상일 경우 탐색한 좌표들을 모두 ‘.’ 으로 변경, 탐색한 개수를 리턴
    - 탐색한 개수가 4개 미만일 경우 0을 리턴
    

그 후 터뜨려진 뿌요 정보를 가진 field에서 각 열을 문자열로 보고, 해당 문자열에서 .을 모두 삭제한 후 총 길이(12)만큼 앞쪽에 .을 붙인다.

ex ) “…….RR…” → “RR” → “……….RR”

그 후 다시 field에 집어넣으면 1번 시뮬레이션을 진행한 것이다. 따라서 1, 2번에서 터진 뿌요가 없을 때까지 시뮬레이션을 진행한다.

<br>

> 코드
> 

<br>

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11559 {

	static char[][] field;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		field = new char[12][6];
		
		for(int i=0;i<12;i++) {
			String line = br.readLine();
			for(int j=0;j<6;j++) {
				field[i][j] = line.charAt(j);
			}
		}
		
		int answer = 0;
		
		// 더 이상 터지지 않을 때 까지 시뮬레이션 실행
		while(go()) {
			answer++;
		}
		
		System.out.println(answer);
	}
	
	static boolean[][] visited;
	public static boolean go() {
		
		// 방문하지 않은 뿌요를 만나면 같은 색의 뿌요를 bfs로 탐색
		// 만약 탐색한 같은색의 뿌요가 4개 이상일 경우 해당 뿌요를 제거(.으로 바꾸기)하고 제거한 수를 반환
		
		visited = new boolean[12][6];
		
		int removeCnt = 0;
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(field[i][j] != '.' && !visited[i][j])
					removeCnt += bfs(i, j);				
			}
		}
		
		// 제거한 뿌요가 있다면 공중에 떠있는 뿌요들을 밑으로 떨어뜨림
		if(removeCnt > 0) {
			dropPuyo();
			return true;
		}
		
		// 제거한 뿌요가 없다면 시뮬레이션 종료
		return false;
		
		
		
	}
	
	public static class Node{
		int r ,c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	public static int bfs(int r, int c) {
		visited[r][c] = true;
		
		char color = field[r][c];
		
		List<Node> visitedNode = new ArrayList<>();
		visitedNode.add(new Node(r,c));
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		
		int cnt = 1;
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				if(nr<0||nr>=12||nc<0||nc>=6||visited[nr][nc]||color != field[nr][nc]) continue;
				visited[nr][nc] = true;
				visitedNode.add(new Node(nr,nc));
				cnt++;
				q.add(new Node(nr,nc));
				
			}
		}
		
		// 같은 뿌요를 4개 이상 탐색했다면 해당 뿌요를 .으로 바꿈
		if(cnt >= 4) {
			boom(visitedNode);
			return cnt;
		}
		
		return 0;
	}
	
	// 방문한 뿌요를  .으로 변경
	public static void boom(List<Node> visitedNode) {
		for(Node node : visitedNode) {
			field[node.r][node.c] = '.'; 
		}
	}
	
	// 공중에 떠있는 뿌요를 밑으로 떨어뜨림
	public static void dropPuyo() {
		
		// 각 열을 문자열로 보고 문자열을 받아 .을 ""로 변경 (".....AA....." -> "AA")
		// 다시 길이 12만큼 앞에 .을 채워넣음 ("..........AA")
		// 기존 필드에 다시 적용
		
		String[] calStrArr = new String[6];
		
		for(int j=0;j<6;j++) {
			String calStr = "";
			for(int i=0;i<12;i++) {
				calStr += field[i][j];
			}
			calStr = calStr.replace(".","");
			
			int len = calStr.length();
			for(int i=0;i<12-len;i++) {
				calStr = "."+calStr;
			}
			
			calStrArr[j] = calStr;
		}
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				field[i][j] = calStrArr[j].charAt(i);
			}
		}
		
	}

}
```
