# Singleton 디자인 패턴



- 객체의 생성을 제한해야 한다면?
    - 여러 개의 객체가 필요 없는 경우
        - 객체를 구별할 필요가 없는 경우 == 수정 가능한 멤버 변수가 없고 기능만 있는 경우
        - 이런 객체를 stateless한 객체라 부름
    - 객체를 계속 생성/삭제 하는데 많은 비용이 들어서 재사용이 유리한 경우
- Singleton 디자인 패턴
    - 외부에서 생성자에 접근 금지 → 생성자의 접근 제한자를 private로 설정
    - 내부에서는 private에 접근 가능 하므로 직접 객체 생성 → 멤버 변수이므로 private 설정
    - 외부에서 private member에 접근 가능한 getter 생성 → setter는 불필요
    - 객체 없이 외부에서 접근할 수 있도록 getter와 변수에 static 추가
    - 외부에서는 언제나 getter를 통해서 객체를 참조하므로 하나의 객체 재사용
    

```java
public class SingleTeacher{
	
	// static을 활용해 메모리에 객체 할당
	private static SingleTeacher st = new SingleTeacher();

	private SingleTeacher(){} // 생성자를 private
	
	// static으로 getTeacher 함수를 메모리에 할당
	public static SingleTeacher getTeacher(){
		return st;
	}
	void teach(){
		System.out.println("참 쉽죠잉?");
	}
}

public class SingleTeacher {
	public static void main(String[] args){
		SingleTeacher st1 = SingleTeacher.getTeacher();
		
		SingleTeacher st2 = SingleTeacher.getTeacher();

		st1.teach();
		st2.teach();

		// st1 == st2

	}
}
```
