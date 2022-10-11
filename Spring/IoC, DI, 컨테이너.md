## 제어의 역전 IoC(Inversion of Control)

- 기존의 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고, 실행
- 즉 구현 객체가 프로그램의 제어 흐름을 스스로 조종
- 반면에 AppConfig가 등장한 이후 구현 객체는 자신의 로직을 실행하는 역할만 담당. 프로그램의 제어흐름은 AppConfig가 가져간다
- 프로그램의 제어 흐름은 모두 AppConfig가 가진다
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아닌  외부에서 관리하는 것을 제어의 역전이라 한다

<br>
<br>

## 프레임워크 vs 라이브러리

- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행한다 (JUnit)
- 내가 작성한 코드가 직접 제어의 흐름을 담당하면 라이브러리이다.
- 
<br>
<br>

## 의존관계 주입 DI (Dependency Injection)

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7d146391-94a5-4991-88a4-777aee3a4bd6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221011%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221011T122515Z&X-Amz-Expires=86400&X-Amz-Signature=63bf048900ae748d39f21068a7c69bf305efd37934c1bbd79292b792e5cae6e5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- OrderServiceImpl는 DiscountPolicy 인터페이스에 의존하지만 실제 어떤 구현체가 사용되는지 모른다.
- 의존 관계는 정적인 클래스 의존관계와 동적인 객체 의존 관계로 분리하여 생각한다.

### 정적인 클래스 의존관계

- 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다.
- 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다.
- 위 그림에서 OrderServiceImpl는 MemberRepository와 DiscountPolicy를 의존한다는 것을 알 수 있다. 하지만 실제 어떤 객체가 주입될 지는 알 수 없다.

### 동적인 객체 인스턴스 의존관계

- 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계이다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/61da91ff-dca9-4b65-8e3d-0c8d786930a7/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221011%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221011T122437Z&X-Amz-Expires=86400&X-Amz-Signature=c2dbe25f605ce4c02e61040da6d022ef5f16c6e9f843aae0eb66f3d31bc17029&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 런타임에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달하여 의존관계가 연결되는 것을 의존관계 주입이라 한다.
- 의존관계 주입 시 클라이언트 코드를 변경하지 않고 클라이언트가 사용할 인터페이스의 구현체를 변경할 수 있다.
- 의존관계 주입 시 정적인 클래스 의존관계를 변경하지 않고 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

<br>
<br>

## IoC 컨테이너, DI 컨테이너

AppConfig 처럼 외부에서 객체를 생성하고 관리하면서 의존관계를 연결하는 것을 IoC 컨테이너 혹은 DI 컨테이너라 한다
