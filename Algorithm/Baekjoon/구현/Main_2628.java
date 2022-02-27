import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2628 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		boolean[] rows = new boolean[R];
		boolean[] cols = new boolean[C];
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(type==0) rows[num] = true;
			else if(type==1) cols[num] = true;
		}
		
		int maxR = 0;
		int sub = 0;
		for(int i=0;i<R;i++) {
			if(!rows[i]) sub++;
			else {
				maxR = Math.max(maxR, sub);
				sub = 1;
			}
		}
		maxR = Math.max(maxR, sub);
		
		int maxC = 0;
		sub = 0;
		for(int i=0;i<C;i++) {
			if(!cols[i]) sub++;
			else {
				maxC = Math.max(maxC, sub);
				sub = 1;
			}
		}
		maxC = Math.max(maxC, sub);
		System.out.println(maxR*maxC);
	}

}
