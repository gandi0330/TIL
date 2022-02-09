<h3>[Java] SWEA / ladder2 / 1211번 </h3>

> 문제
> 

[Ladder2 문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14BgD6AEECFAYh)

문제의 저작권은 SW Expert Academy에 있습니다

> 입력
> 

각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.

총 10개의 테스트 케이스가 주어진다.

```
1
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 1 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 0 0 ...
1 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
1 1 1 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 0 0 0 ...
1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 ...
...
```

<br>
<br>

> 출력
> 

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 도착하게 되는 출발점의 x좌표를 출력한다.

```
#1 18
...
```

<br>
<br>

> 접근 방식
> 
1. 사다리 도착점부터 시작해서 dfs 탐색한다
2. 현재 위치에서 수직으로 이동하는지 수평으로 이동하는지 확인하기 위한 매개변수를 dfs에 추가한다
3. 만약 수직으로 이동 중에 양 옆에 사다리가 없으면 계속 수직으로 이동한다
4. 만약 수직으로 이동 중에 양 옆에 사다리가 있으면 해당 방향으로 방향 매개변수를 바꾸고 다시 dfs를 호출한다
5. 수평으로 이동 중 위쪽 방향에 사다리가 있으면 수직 방향으로 방향 매개변수를 바꾸고 다시 dfs를 호출한다

<br>
<br>

> 코드
> 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_정현명 {

	static int R = 0;
	static int C = 0;
	static int[][] ladder;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		
		for (int tc = 1; tc<= 10; tc++) {
			br.readLine(); // tc 번호 안써서 할당 안함
			
			// 사다리 배열
			ladder = new int[100][100];
			
			
			// 사다리 입력
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						R = i;
						C = j;
					}
				}
			}
			
			// 0은 위로, -1은 왼쪽으로, 1은 오른쪽으로 이동
			dfs(0);
			
			
			sb.append("#").append(tc).append(" ").append(C).append("\n");
			
		}
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}
	
	public static void dfs(int direction) {
		// 위로 갈 때
		if(direction == 0) {
			int nextR = R-1;
			// 출발점으로 도착 시 
			if(nextR == 0) {
				R = nextR;
				return;
			}
			
			else {
				// 위로 이동
				R = nextR;
				
				// 이동 후 왼쪽과 오른쪽 검사
				int nextC1 = C-1;
				int nextC2 = C+1;
				
				// 왼쪽에 사다리 있으면 이동
				if(nextC1 >= 0 && (ladder[R][nextC1] == 1)) {
					dfs(-1);
				}
				// 오른쪽 사다리 있으면 이동
				else if(nextC2 <100 && (ladder[R][nextC2] == 1)) {
					dfs(1);
				}
				// 그대로
				else {
					dfs(0);
				}
			}
			
		}
		// 왼쪽으로 갈 때
		else if (direction == -1){
			// 왼쪽으로 이동
			C = C-1; 
			
			// 수평 기준으로 위로 가는 방향 검사
			if(ladder[R-1][C] == 1) {
				dfs(0);
			}
			else {
				dfs(-1);
			}
			
		}
		
		else if(direction == 1) {
			//오른쪽으로 이동
			C = C+1;
			
			//수평 기준으로 위로 가는 방향 검사
			if(ladder[R-1][C] == 1) {
				dfs(0);
			}
			else {
				dfs(1);
			}
		}
	}

}

```
