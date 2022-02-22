import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_4195 {

	
	static Map<String, Integer> map;
	static int[] parents;
	static int[] level;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		 
		
		
		for(int i=0;i<T;i++) {
			int F = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			parents = new int[F * 2];
			level = new int[F * 2];
			
			for(int j=0;j<F*2;j++) {
				parents[j] = j;
				level[j] = 1;
			}
			
			int idx = 0;
			for(int j=0;j<F;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
				
				sb.append(union(map.get(a),map.get(b))+"\n");
				
				System.out.println(map.toString());
				System.out.println(Arrays.toString(level));
			}
		}
		System.out.print(sb);
		
	}
	
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static int union(int a, int b) {
		
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) {
			parents[b] = a;
			level[a] += level[b];
			
			level[b] = 1;
		}
		
		return level[a];
	}

}
