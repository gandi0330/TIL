![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F72677a84-5c33-415d-80f0-1dca76aabe1b%2FUntitled.png?table=block&id=2f01c01b-bd29-43d3-bbe3-4b80814d3b88&spaceId=ff6a514b-b258-41a8-b9af-c6ca55789a5a&width=2000&userId=f82d3d2f-968d-478f-a6d7-20d09d73ce71&cache=v2)

- BeanFactory
    - 스프링 컨테이너의 최상위 인터페이스
    - 스프링 빈을 관리하고 조회하는 역할 담당
    - 대표적으로 제공 : getBean()

- ApplicationContext
    - BeanFactory 기능을 모두 상속받아 사용. 따라서 BeanFactory를 직접 사용하기 보단 ApplicationContext를 주로 사용
    - 이 외에 다양한 인터페이스를 상속받아 사용
    - BeanFactory나 ApplicationContext를 스프링 컨테이너라 한다.
    
![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F25d6031e-20d3-4076-ae1e-0e758cd5cdab%2FUntitled.png?table=block&id=947468c5-c022-4f6b-88be-40967811953f&spaceId=ff6a514b-b258-41a8-b9af-c6ca55789a5a&width=2000&userId=f82d3d2f-968d-478f-a6d7-20d09d73ce71&cache=v2)
