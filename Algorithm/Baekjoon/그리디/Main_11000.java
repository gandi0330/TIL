import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000 {
	
	public static class Lecture implements Comparable<Lecture>{
		
		int start;
		int end;
		
		Lecture(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			
			return this.start - o.start;
		}
		
	}
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Lecture(start,end));
		}
		
		
		PriorityQueue<Integer> endPq = new PriorityQueue<>();
		
		while(!pq.isEmpty()) {
			Lecture data = pq.poll();
			if(endPq.isEmpty()) {
				endPq.offer(data.end);
			}
			else {
				// 기존 강의실이 존재하면 강의실의 종료 시간 중 최소 값과 비교
				// 만약 강의실 종료 시간보다 시작 시간이 크거나 같으면 종료 시간 갱신
				if(data.start >= endPq.peek()) {
					endPq.poll();
					endPq.offer(data.end);
				}
				
				// 강의실 종료 시간보다 시작 시간이 작으면 강의실 추가 (강의실 종료 시간 추가)
				else {
					endPq.offer(data.end);
				}
			}
		}
		
		
		System.out.println(endPq.size());
	}

}
