import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int directions[] = new int[6];
		int distance[] = new int[6];
		
		
		for(int i=0; i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			directions[i] = Integer.parseInt(st.nextToken());
			distance[i] = Integer.parseInt(st.nextToken());
			
			
		}
		
		
		for(int i=0;i<6;i++) {
			if(directions[i] == directions[(i+2) % 6] && directions[(i+1) % 6] == directions[(i+3) % 6]) {
				System.out.println((distance[(i+4) % 6] * distance[(i+5) % 6] - distance[(i+1) % 6] * distance[(i+2) % 6])*K);
				break;
			}
		}
	}

}
