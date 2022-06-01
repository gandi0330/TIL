<h3>[알고리즘]  Java / 백준 / IOIOI / 5525 </h3>

> 문제
> 

<br>

[문제 링크](https://www.acmicpc.net/problem/5525)

<br>

> 접근 방식
> 

<br>

substring을 활용한 방법을 사용했더니 절반만 통과하였다.

때문에 O(N)의 방법으로 문제를 해결해야 한다.

1. 문자열을 처음부터 탐색하여 “I”를 찾으면 그 뒤의 “OI” 개수를 센다.
2. 입력받은 Pn의 n보다 “OI” 개수가 같거나 크면 그 차이 개수 + 1 만큼을 cnt 변수에 더한다.

<br>

> 코드
> 

<br>

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int cnt = 0;
		
		for(int i=0;i<=M - (2*N+1); i++) {
			
			// 맨 앞자가 I라면 뒤에 OI가 몇개 붙는지 확인 
			if(S.charAt(i) == 'I') {
				int cntOI = 0;
				while(i+2 < M && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') {
					cntOI++;
					i+=2;
				}
				
				if(cntOI >= N) {
					cnt += 1 + (cntOI - N);
				}
			}
		}
		
		System.out.println(cnt);
	}

}
```
