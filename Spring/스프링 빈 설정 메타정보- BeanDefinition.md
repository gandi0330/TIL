스프링은 BeanDefinition이라는 추상화를 통해 다양한 설정 형식을 지원

XML을 읽어서 BeanDefinition을 만듦, 자바 코드를 읽어 BeanDefinition을 만듦

스프링 컨테이너는 설정 정보가 자바이든 XML이든 상관없이 BeanDefinition만 알면 된다.

BeanDefinition을 빈 설정 메타정보라 한다.

@Bean, <bean> 각각 하나씩 메타 정보가 생성된다.

스프링 컨테이너는 이 메타정보를 기반으로 스프링 빈을 생성한다.

![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F835e5935-4ac5-4b69-b47a-1d4362c9cdd7%2FUntitled.png?table=block&id=28ff38f0-9ebe-4331-baad-7503cb080ff3&spaceId=ff6a514b-b258-41a8-b9af-c6ca55789a5a&width=2000&userId=f82d3d2f-968d-478f-a6d7-20d09d73ce71&cache=v2)

각 설정파일들을 각각의 Reader에 의해 BeanDefinition으로 변환된다. 

### BeanDefinition 정보

- BeanClassName : 생성할 빈의 클래스 명
- factoryBeanName : 팩토리 역할의 빈을 사용할 경우 이름 ( AppConfig )
- factoryMethodName : 빈을 생성할 팩토리 메서드 지정 ( memberService)
- Scope : 싱글톤(기본)
- lazyInit : 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아닌 실제 빈을 사용할 때 까지 최대한 생성을 지연하는지의 여부
- InitMethodName : 빈을 생성하고 의존관계를 적용한 뒤 호출되는 초기화 메서드
- DestroyMethodName : 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드
- Constructor arguments, Properties : 의존관계 주입에서 사용

### 요약

- BeanDefinition을 직접 생성하여 스프링 컨테이너에 등록할 수 있다.
- 스프링이 다양한 형태의 설정 정보를 BeanDefinition으로 추상화해서 사용한다.
