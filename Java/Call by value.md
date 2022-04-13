# Java는 call by reference가 없다?


>### call by value?

- 값을 호출하는 것을 의미한다.
- 전달 받은 값을 복사하여 처리한다.
- 전달 받은 값을 변경하여도 원본은 변경되지 않는다.

```c
void func(int n){
	n = 10;
}

void main(){
	int n = 20;
	func(n); // 값 복사하여 전달 (call by value)
	printf("%d",n); // 20
}
```

<br>
<br>

>### call by reference?

- 참조에 의한 호출을 의미한다.
- 전달 받은 값을 직접 참조한다.
- 전달 받은 값을 변경할 경우 원본도 변경된다.

```c
void func(int *n){
	*n = 10;
}

void main(){
	int n = 20;
	func(&n); // 주소 값 전달 (call by reference)
	printf("%d",n); // 10
}
```

<br>
<br>

>### 자바는 call by reference가 없다?

우리는 Java에서 객체를 전달받고 그 객체를 수정하면 원본도 같이 수정되기 때문에 이를 call by reference로 착각한다.

```java
class Person{
	public int age;
	Person(int age){
		this.age = age;
	}
}

public static void main(String[] args){
	Person p1 = new Person(10);
	Person p2 = new Person(20);
	run(p1,p2);
}

public static void run(Person arg1, Person arg2){
	arg1.age = 111;
	arg2 = arg1;
}
```

위의 코드 결과는 다음과 같다.

```java
p1.age = 111

p2.age = 2

arg1.age = 111

arg2.age = 111
```

run 메서드에서 p1을 참조받은 arg1의 age를 바꿨더니 p1의 age 또한 바뀌었다.

이를 우리는 call by reference라고 생각한다. (원본이 바뀌었으니)

하지만 정확히는 p1에서 arg1로 넘기는 과정에서 call by value로 p1의 주소값을 복사해서 arg1로 넘기고, arg1는 복사된 주소값으로 해당 주소가 가리키는 age를 변경한 것이다.

만약 call by reference로  arg1과 arg2가 전달받았다면 매개변수를 변경할 경우 원본도 같이 변경되기 때문에 p2또한 111이 되었을 것이다.

<br>
<br>

>### 결론

자바는 call by value 방식으로만 함수를 호출한다.

데이터 값을 복사해서 함수로 전달하기 때문에 원본의 데이터가 변경될 가능성이 없다.

하지만 인자를 넘겨줄 때마다 메모리 공간을 할당하기 때문에 메모리 공간을 더 잡아먹는다.

참고 https://deveric.tistory.com/92
