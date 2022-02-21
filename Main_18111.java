import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[N][M];
		
		int max = 0;
		int min = 257;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, mat[i][j]);
				min = Math.min(min, mat[i][j]);
			}
		}
		
		int floorMax = min;
		int timeMin = Integer.MAX_VALUE;
		
		for(int i=min;i<=max;i++) {
			int time = 0;
			int block = B;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(mat[r][c] > i) {
						time += 2* (mat[r][c] - i); 
						block += mat[r][c] - i;
					}
					else if(mat[r][c] < i) {
						time += i - mat[r][c];
						block -= i - mat[r][c];
						
					}
				}
			}
			
			
			if(block >= 0 && time <= timeMin) {
				if(time == timeMin) {
					floorMax = floorMax > i ? floorMax : i;
				}
				else {
					floorMax = i;
					timeMin = time;
				}
			}
		}
		
		System.out.println(timeMin + " " + floorMax);
		
		
		
	}

}
