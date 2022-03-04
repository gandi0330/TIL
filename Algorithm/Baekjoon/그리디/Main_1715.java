import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		if(n==1) {
			System.out.println(0);
		}
		else {
			int sum = 0;
			
			while(true) {
				int a = pq.poll();
				int b = pq.poll();
				
				sum += a + b;
				if(pq.size()== 0) break;
				
				pq.offer(a+b);
			}
			
			System.out.println(sum);
			
		}
		
		
	}

}
