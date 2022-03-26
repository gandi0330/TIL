# [알고리즘 개념] Union-find 


> 개념

union-find 는 크게 union과 find로 나뉜다

- union(x,y) 연산은 원소 x와 y가 속해있는 집합을 입력으로 받아 2개의 집합을 합집합으로 만든다
- find(x) 연산은  원소 x가 속해있는 집합을 반환한다.

```
// union 함수 구현
union(a,b):
	rootA = find(a) //a의 루트 찾기
	rootB = find(b) //b의 루트 찾기
	if rootA != rootB : // 합친다
		parent[rootA] = rootB;
	
// find 함수 구현
find(a):
	if(parent[a] == -1) // a가 루트라면
		return a;
	while(parent[a] != -1) a = parent[a]; // a가 루트가 될때까지 계속 부모를 부름
	return a; 
```
<br>
<br>




> 구현


```java
import java.util.Arrays;

public class algorithm_unionfind {

	static int parent[];
	public static void main(String[] args) {
		
		// 1. 부모를 가리키는 배열 생성
		parent = new int[10];
		for(int i=0;i<10;i++) { //자신을 가리키도록 초기화
			parent[i] = i;
		}
		
		
		// 홀수만 묶어보기
		union(3,5);
		union(5,7);
		union(1,3);
		union(9,3);
		
		System.out.println(Arrays.toString(parent));
		// [0,9,2,1,4,3,6,3,8,9]		

		// 최상위 부모만을 가리키도록 하기 위한 부모 갱신
		for(int i=0;i<10;i++) {
			parent[i] = find(i);
		}
		System.out.println(Arrays.toString(parent));
		// [0,9,2,9,4,9,6,9,8,9]
	}
	
	
	// 2. 모든 루트의 자식이 루트를 가리키도록 설정하면서 루트를 찾음
	public static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	// 3. y의 부모를 x로 하여 합집합을 만듦
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;

	}

}
```
