# REST(Representational State Transfer) API


### REST 개념
 - 웹에서 데이터를 전송하고 처리하는 방법을 정의한 인터페이스.
 - 하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다는 개념에 전송방식을 결합해서 원하는 작업을 지정.
 - **HTTP URI를 통해 제어할 자원을 명시하고, HTTP Method(GET, POST, PUT, DELETE)를 통해 해당 자원을 제어하는 명령을 내리는 방식의 아키텍처.**

<br>
<br>

### REST 구성
- 자원 : URI로 자원 구분
- 행위 : Method로 자원에 대한 행위를 구분
  - GET : 자원 조회
  - POST : 자원 생성
  - PUT : 자원의 전체항목 수정
  - fetch : 자원의 일부항목 수정
  - DELETE : 자원의 삭제
- 표현 : XML, JSON, RSS 포맷으로 자원을 나타내기

-> **잘 표현된 HTTP URI로 리소스를 정의하고 HTTP Method로 리소스에 대한 행위를 정의한다. 또한 리소스는 JSON, XML과 같은 여러가지 언어로 표현할 수 있다.**

<br>
<br>

### REST API
REST 서비스를 구현한 것

- REST URI 설계 가이드
1) 동사 지양, 명사 지향 (URI에서는 자원에 대한 정의만 하고 행위는 HTTP Method로 설계)
2) _ 언더바 지양, - 하이픈 지향
3) 마지막 / 사용 금지
4) 확장자 사용 금지

<br>
<br>

### REST API 장단점
- 장점
  - HTTP 프로토콜 사용 -> 추가적인 인프라 구축이 필요 없음
  - 클라이언트 서버 환경 구축 가능 -> 분리된 개발이 가능
- 단점
  - 표준화가 되어있지 않고 암묵적인 표준만 정해져 있음

<br>
<br>

### RESTful
REST 아키텍처를 잘 준수한 것
