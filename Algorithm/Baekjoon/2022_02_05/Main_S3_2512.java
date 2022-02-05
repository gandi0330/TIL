import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2512 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int l = 1;
		int r = max;
		
		int answer = 0;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			int sum = 0;
			
			for(int i=0;i<N;i++) {
				if(arr[i] <= mid) {
					sum+= arr[i];
				}
				else {
					sum+= mid;
				}
			}
			
			if(sum > M) {
				r = mid -1;
			}
			else {
				answer = mid;
				l = mid + 1;
			}
		}
		
		System.out.println(answer);
				
	}

}
