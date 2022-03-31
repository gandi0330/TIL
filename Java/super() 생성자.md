# super() 생성자



특징

- super()는 자식 클래스 생성자의 맨 첫 줄에서만 호출이 가능하다
- 명시적으로 this() 또는 super()를 호출하지 않으면 디폴트로 super가 삽입된다
    
    ⇒ 결론적으로 맨 상위 Object까지 객체가 다 만들어진다
    
- **부모 클래스의 생성자를 파라미터가 있는 생성자로 만들었을 때 자식 클래스의 생성자에 디폴트 로 super()가 삽입 되면 파라미터가 없는 부모 생성자가 삽입 되는 것이므로 충돌이 일어난다**

```java
class Person {
	String name;
	Person(String name){
		// super(); 가 생략되어 있다 , 이 때 super는 Object
		this.name = name;
	}
}

public class SpiderMan extends Person{
	SpiderMan(String name){
		// super(); 가 생략되어 있다, 이 때 super는 Person인데 매개변수를 가지므로 오류가 생긴다.
		// 따라서 super(name); 을 명시해줘야 한다
		super(name);
	}

}
```
