import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int asc = 1;
		int desc = 1;
		int pre;
		int now = -1;
		int answer = 1;
		for(int i=0;i<N;i++) {
			pre = now;
			now = Integer.parseInt(st.nextToken());
			
			
			if(pre == -1) {
				continue;
			}
			
			else if(pre < now) {
				asc++;
				answer = Math.max(answer, desc);
				desc = 1;
			}
			else if(pre > now) {
				desc++;
				answer = Math.max(answer, asc);
				asc = 1;
			}
			else {
				asc++;
				desc++;
			}
			
		}
		
		answer = Math.max(Math.max(asc, desc), answer);
		
		System.out.println(answer);
	}

}
