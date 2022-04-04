# [알고리즘 개념] 최장 증가 부분 수열 (LIS)


> Longest Increasing Subsequence

최장 증가 부분 수열

→ 어떤 수열이 왼쪽에서 오른쪽으로 나열돼 있으면, 그 배열 순서를 유지하면서 **크기가 점진적으로 커지는 가장 긴 부분수열을 추출**하는 문제

- Brute-force 접근방법
    
    수열의 모든 부분집합을 구하여 그 부분집합이 증가 수열인지 판별하기
    
    → 시간복잡도가 O(2^n)
    

- DP 접근방법
    
    원소가 a1, a2, a3 ... an 이고 i번째까지의 최장 부분 수열 길이를 LIS(i)라 할 때,
    
    **LIS(i) = 1 + LIS(j)**    ( j < i and aj < ai )
    
    → 시간복잡도가 O(n^2)
    
<br>
<br>

> 예시 문제 

[SWEA 최장 증가 부분수열 문제](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int[] arr = null;
		int[] dp = null;
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			dp = new int[N];
			int maxValue = 0;
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				dp[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				if(maxValue < dp[i]) maxValue = dp[i];
			}
			
			sb.append("#"+tc+" "+maxValue+"\n");
			
		}
		
		System.out.println(sb);
	}
}
```
