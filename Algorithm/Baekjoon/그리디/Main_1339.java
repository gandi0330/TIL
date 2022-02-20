import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main_1339 {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			
			for(int j=0;j<str.length();j++) {
				char alpha = str.charAt(j);
				if(map.containsKey(alpha)) map.put(alpha, map.get(alpha) + (int)Math.pow(10, str.length() -1 -j));
				else map.put(alpha, (int)Math.pow(10, str.length() -1 -j));
			}
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int num : map.values()) {
			list.add(num);
		}
		
		Collections.sort(list,(a,b) -> b - a);
		
		int sum = 0;
		for(int i=0;i<list.size();i++) {
			sum+= list.get(i) * (9-i);
		}
		
		System.out.println(sum);
	}
	
	
		
}
