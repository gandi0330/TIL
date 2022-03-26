# HTTP Protocol


Hypertext Transfer Protocol은 인터넷 상에서 데이터를 주고 받기 위한 서버/클라이언트 모델을 따르는 프로토콜

어플리케이션 레벨의 프로토콜로 TCP/IP 위에서 작동

HTTP는 어떤 종류의 데이터든지 전송할 수 있도록 설계되어있음

HTML문서, 이미지, 동영상, 오디오, 텍스트 문서 등

링크 기반으로 데이터에 접속

### 특징

- 서버/클라이언트 모델
    - 클라이언트에서 요청을 보내면 서버는 요청을 처리해서 응답한다
    - 클라이언트는 서버에 요청하는 소프트웨어(chrome 등)가 설치된 컴퓨터를 이용하여 URI를 이용해 서버에 접속하고 데이터를 요청할 수 있다
    - 서버는 클라이언트의 요청을 받아서 요청을 해석하고 응답을 한다
    - 웹 서버는 보통 표준포트인 80번 포트로 서비스한다

- Connectionless & Stateless
    - HTTP는 Connectionless 방식으로 작동하는데 서버에 연결하고 요청해서 응답을 받으면 끊는다
    - 자원 하나에 하나의 연결을 만든다
        - 장점
            - 불특정 다수를 대상으로 하는 서비스에 적합하다
            - 접속유지를 최소한으로 하여 더 많은 유저의 요청을 처리할 수 있다
        - 단점
            - 연결을 끊기 때문에 클라이언트의 이전 상태를 알 수 없다
            - 클라이언트가 과거에 로그인을 성공하더라도 로그 정보를 유지할 수 없다 ( 그래서 cookie를 사용 )

- URI (Uniform Resorce Identifiers)
    - 클라이언트 소프트웨어는 URI를 이용하여 자원의 위치를 찾는다
    - URI는 자원의 위치를 알려주기 위한 프로토콜
    - 프로토콜, 위치, 자원 명으로 어디서든 자원에 접근할 수 있다

- Method
    - GET : 정보를 요청하기 위해 사용
    - POST : 정보를 밀어넣기 위해 사용
    - PUT : 정보를 업데이트 하기 위해 사용
    - DELETE : 정보를 삭제하기 위해 사용
    - HEAD : HTTP 헤더 정보만 요청하여 자원존재유무나 서버 문제 확인
    - OPTIONS : 웹 서버가 지원하는 메서드 종류 요청
    - TRACE : 클라이언트 요청을 그대로 반환 (echo)
    
    - 하지만 GET, POST만으로 모든 요청을 표현할 수 있음
    - GET
        - 데이터를 서버로 받아올 때 주로 사용하는 method
        - 가장 많이 사용됨
        - Http request message의 body에 담지않고 쿼리 스트링을 통해 전송
        - 쿼리스트링은 url 끝에 ?와 함께 key value로 쌍을 이루는 요청 파라미터. 요청 파라미터가 여러개면 &로 연결
        
        ```
        http://www.example-url.com/resources?name1=value1&name2=value2
        ```
        
    - POST
        - 데이터를 생성,수정,삭제 할때 주로 사용
        - Http request message의 body에 데이터를 넣어 보내짐
        
    
- GET과 POST의 차이
    - GET은 멱등, POST는 멱등하지 않도록 설계되었다
    - 멱등이란 동일한 연산을 여러번 수행해도 동일한 결과가 나온다는 뜻이다
    - 따라서 GET은 서버에게 동일한 요청을 여러 번 전송하더라도 동일한 응답이 돌아와야 한다. 때문에 설계원칙에 따라 서버의 데이터나 상태를 변경시키지 않아야하므로 조회를 할 때 사용한다
    - POST는 멱등하지 않기 때문에 서버에게 동일한 요청을 여러 번 전송해도 응답은 다를 수 있다. 따라서 POST는 생성, 수정, 삭제에 사용할 수 있다

- HTTP Message 구조

요청


- request line ( start line )
    - Http 메서드 / 요청 타겟 / HTTP 버전

- request headers
    - key : value로 이루어짐
    - Host : 요청하려는 서버 호스트 이름과 포트번호
    - Referer : 바로 직전에 머무른 링크 주소
    - Accept : 클라이언트가 처리 가능한 미디어 타입 종류
    - User-Agent : 클라이언트 프로그램 정보(서버가 이에 맞춰 최적의 데이터를 보냄)
    - Cookie
    - Origin : 서버로 Post 요청을 보낼 때 요청이 어느 주소에 시작되었는지 나타냄. 이 값으로 요청을 보낸 주소와 응답 받는 주소가 다르면 CORS 에러 발생 (Cross-Origin Resource Sharing)

- Body
    - HTTP Request가 전송하는 데이터를 담는 부분
    - 전송하는 데이터가 없으면 생략됨

응답


- Start Line
    - Http version / Status Code / Status Text

- Header
    - Server : 웹 서버의 종류
    - Age
    - Referred-policy
    - ..인증 등등..

- Body
    - HTTP Request 메세지의 body와 동일
    

참고자료

[https://hongsii.github.io/2017/08/02/what-is-the-difference-get-and-post/](https://hongsii.github.io/2017/08/02/what-is-the-difference-get-and-post/)

[https://velog.io/@teddybearjung/HTTP-구조-및-핵심-요소](https://velog.io/@teddybearjung/HTTP-%EA%B5%AC%EC%A1%B0-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%9A%94%EC%86%8C)

[https://shlee0882.tistory.com/107](https://shlee0882.tistory.com/107)

[https://gmlwjd9405.github.io/2019/04/17/what-is-http-protocol.html](https://gmlwjd9405.github.io/2019/04/17/what-is-http-protocol.html)

[https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Network#http의-get과-post-비교](https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Network#http%EC%9D%98-get%EA%B3%BC-post-%EB%B9%84%EA%B5%90)
