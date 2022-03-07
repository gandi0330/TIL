import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {

	static long A,B,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		A = A % C;
		
		System.out.println(divide(A,B));
		
	}
	
	public static long divide(long x, long y) {
//		System.out.println("x:"+x + " y:"+y);
		
		if(y==1) return A;
		
		long tmp = divide(x,y/2) % C;
		
		
		if(y % 2 == 1) return ((A*tmp) % C )*tmp % C;
		else return (tmp*tmp)%C;
		
	
	}

}
