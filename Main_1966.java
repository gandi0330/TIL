import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int maxImportance = 0;
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 수
			int M = Integer.parseInt(st.nextToken()); // M번째 수가 몇 번째로 인쇄되었는지
			
			Queue<int[]> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				int importance = Integer.parseInt(st.nextToken());
				maxImportance = Math.max(maxImportance, importance);
				que.offer(new int[] {importance, j});
			}
			
			int cnt = 0;
			while(!que.isEmpty()) {
				int importanceMax = 0;
				for(int[] arr : que) {
					importanceMax = Math.max(importanceMax, arr[0]);
				}
				int[] info = que.poll();
				if(info[0] >= importanceMax) {
					cnt++;
					if(info[1] == M) {
						System.out.println(cnt);

						break;
					}
				}
				else {
					que.offer(info);
				}
			}
			
		}
	}

}
