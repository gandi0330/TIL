### [알고리즘 개념] 최소신장트리(MST)-Kruskal

> 개념

- 탐욕적인 방법으로 최소신장트리를 구한다
    - 순서
        1. 간선들의 가중치를 오름차순으로 정렬한다
        2. 정렬된 간선들의 리스트에서 사이클을 형성하지 않는 간선을 찾아 현재의 최소비용 신장트리의 집합에 추가한다
    - 실제로 사이클을 알기 위해서는 연결하려는 간선의 양 끝점이 동일한 집합에 없는지를 체크해야 한다. 이를 위해서 union-find 알고리즘을 사용한다

<br>
<br>

 
>구현
 
 ```java
    import java.util.Arrays;
    
    public class algorithm_kruskal {
    
    	static int parent[];
    	public static void main(String[] args) {
         // =================== 값 세팅 =======================
    		int V = 5; // 정점 수
    		int E = 7; // 간선 수
    
    		parent = new int[V];
    		makeSet();
    				
    		// 7개 간선의 각 정점과 가중치(시작 정점, 끝 정점, 가중치)
    		int graph[][] = new int[E][3];
    		
    		// 임의의 간선과 가중치 부여 (무방향 그래프)
    		// 0 -> 1 -> 2 -> 3 -> 4 로 이어지도록 가중치를 일부러 적게 부여
    		graph[0] = new int[] {0,1,1};
    		graph[2] = new int[] {1,2,1};
    		graph[1] = new int[] {1,3,6};
    		graph[3] = new int[] {1,4,5};
    		graph[4] = new int[] {2,3,1};
    		graph[5] = new int[] {3,4,1};
    		graph[6] = new int[] {3,1,7};
    		
    		//====================== 구현 =========================
            
         // 1. 비용이 낮은 순으로 간선을 정렬
    		Arrays.sort(graph,(o1,o2) -> Integer.compare(o1[2], o2[2]));
    		
    		int cost = 0;
            
    		// 2. 사이클을 만들지 않으면서 최소 비용의 간선 찾기
    		for(int i=0;i<E;i++) {
    			if(union(graph[i][0], graph[i][1])) {
    				cost += graph[i][2];
    			}
    		}
    		
         // ======================= 출력 =========================
    		System.out.println("cost : " + cost);
    		// cost : 4
    		System.out.println("각 정점이 가리키는 부모 : " + Arrays.toString(parent));
    		// 각 정점이 기리키는 부모 : [1, 2, 3, 4, 4]
    	}
    	
        
     // ================= 유니온파인드 =====================
     
    	public static void makeSet() {
    		for(int i=0;i<parent.length;i++) {
    			parent[i] = i;
    		}
    	}
    	
    	public static boolean union(int a, int b) {
    		a = find(a);
    		b = find(b);
    		
    		if(a < b) {
    			parent[a] = b;
    			return true;
    		}
    		else if(a > b) {
    			parent[b] = a;
    			return true;
    		}
    		return false;
    	}
    	
    	public static int find(int a) {
    		if(a == parent[a]) return a;
    		
    		return find(parent[a]);
    		// 경로 압축 
    		// return parent[a] = find(parent[a]);
    	}
    
    }
    
    ```
