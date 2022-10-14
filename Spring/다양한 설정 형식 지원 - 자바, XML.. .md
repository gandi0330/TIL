스프링 컨테이너는 다양한 형식의 설정 정보를 받아드릴 수 있도록 유연하게 설계되어 있다.

(자바, XML, Groovy 등등.. )

![](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Faa97ceeb-74c3-4609-98be-27775b1940ba%2FUntitled.png?table=block&id=652eae0a-d7e5-4cd8-847d-3342bf2be65a&spaceId=ff6a514b-b258-41a8-b9af-c6ca55789a5a&width=2000&userId=f82d3d2f-968d-478f-a6d7-20d09d73ce71&cache=v2)

Annotation 기반 자바코드 설정 사용

```java
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)
```

XML 설정  사용

```java
ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
```
