import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2467 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int f = 0;
		int b = N-1;
		
		int answerF = 0;
		int answerB = 0;
		
		int min = Integer.MAX_VALUE;
		
		while(f<b) {
			
			if(Math.abs(arr[f] + arr[b])< min) {
				min = Math.abs(arr[f] + arr[b]);
				answerF = arr[f];
				answerB = arr[b];
				if(min == 0) break;
			}
			
			if(arr[f] < 0 && arr[b] <0) {
				f++;
			}
			else if(arr[f]>0 && arr[b] >0){
				b--;
			}
			else if(arr[f] + arr[b] > 0){
				b--;
			}
			else if(arr[f] + arr[b] < 0) {
				f++;
			}
		}
		
		System.out.println(answerF+" "+ answerB);
	}

}
