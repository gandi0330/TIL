### DIP (추상에만 의존하기)

- 객체지향 설계원칙 중 DIP를 지키기 위해 인터페이스와 구현체를 나누고, 인터페이스에 의존한다
- 주문 서비스에서 할인 정책을 결정한다고 가정한다면 구조는 다음과 같다

![a](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/067e7b58-c3b0-47ad-8383-897232b74146/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221011%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221011T121908Z&X-Amz-Expires=86400&X-Amz-Signature=33f2e259f4aa79c786bb4334a4be7aeec99c1564bf33c0422bf96bfaba86bd5a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 이를 실제로 코드로 표현하면 다음과 같다

```java
public class OrderServiceImpl implements OrderService {
  // private final DiscountPolicy discountPolicy = new FixDiscountPolicy;
	private DiscountPolicy discountPolicy;
}
```

- 주석처럼 인터페이스에 구현체를 정의하면 OrderServiceImpl는 추상화가 아닌 구현체에 의존하게 된다.
- 주석이 아닌 부분처럼 선언만 하면 discountPolicy는 null이 될 것이다.

### AppConfig 등장

- 우리의 목적은 인터페이스와 구현체로 나누고 인터페이스에 의존하는것이다
- 인터페이스에 의존하기 위해 누군가 인터페이스의 구현 객체를 대신 생성하고 주입해줘야 한다
- 의존관계를 주입해주는 AppConfig를 만들어보자

AppConfig는 구현객체를 생성하여 반환하고 있다

```java
public class AppConfig{
	public OrderService orderService(){
		return new OrderServiceImpl(new FixDiscountPolicy());
	}
}
```

AppConfig로부터 구현객체를 받기 때문에 OrderServiceImpl는 더 이상 구현체에 의존하지 않는다

```java
public class OrderServiceImpl implements OrderService {
	private DiscountPolicy discountPolicy;

	AppConfig appConfig = new AppConfig();
	discountPolicy = appConfig.orderService();	
}
```

AppConfig의 등장으로 애플리케이션이 사용 영역과 구성 영역으로 분리되었다

때문에 구현체(할인 정책)를 바꾸더라도 구성 영역만 영향을 받고 사용 영역은 영향을 받지 않는다
![a](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/38855d46-c3e8-4010-a4d6-a8559a2289c8/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221011%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221011T121958Z&X-Amz-Expires=86400&X-Amz-Signature=80c719efab2c5d11d530f6af8e6184bf1afae45c9d0b6eab8d2c926dfd753b76&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

[출처](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)
