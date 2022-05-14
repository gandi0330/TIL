# JDBC


### JDBC란?

Java DataBase Connectivity의 약자로, 자바 언어로 데이터베이스를 프로그래밍 하기 위한 API입니다.

데이터베이스의 종류와는 상관없이 JDK에서 제공하며 이를 각각의 데이터베이스의 언어에 맞추기 위해 각 데이터베이스의 드라이버가 필요합니다.

![a](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Foed9z%2FbtqDjGqc8Hh%2FfTNTE08lq5mhxWQecAi5k0%2Fimg.png)
출처 [https://devlog-wjdrbs96.tistory.com/139](https://devlog-wjdrbs96.tistory.com/139)

<br>
<br>

### JDBC 연동 순서

![a](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOvHi2%2FbtqDibLdLep%2FRLGbbmViRkyd4jkfDKkGw1%2Fimg.png)
츨처 [https://devlog-wjdrbs96.tistory.com/139](https://devlog-wjdrbs96.tistory.com/139)

1. 원하는 데이터베이스의 드라이버를 로드합니다.
2. 해당 `DriverManager`의 메서드인 `getConnection`을 통해 `Connection` 객체를 얻습니다.
3. 해당 Connection 객체를 통해 SQL문을 보낼 `Statement`를 작성할 수 있습니다. 이 때 `Statement` 혹은 `PreparedStatement`를 사용하는데 자세히는 아래에서 설명하겠습니다.
4. SQL문을 statement 객체에 담은 후 `excuteQuery()` 혹은 `excuteUpdate()`를 사용하여 결과를 받습니다. 

<br>
<br>

### Statement vs PrepareStatment

SQL을 담을 객체이며 둘의 차이는 캐시의 사용 유무 입니다.

Statement를 사용하면 매번 쿼리를 수행할 때 다음과 같은 단계를 거칩니다.

1) 쿼리 문장 분석

2) 컴파일

3) 실행

```java
String sql = "select id, name from user where name="+name ;
Statment stmt = conn.createdStatment()
ResultSet rs = stmt.excuteQuery(sql);
```

PreparedStatment의 Prepared 은 컴파일이 준비됬다는 것을 의미하며 한번 생성 시 메모리에 올라가 이 후에 다시 실행할 때는 ? 부분을 제외한 쿼리는 이미 컴파일 되어있고 ?만 바꿔 실행하기 때문에  성능상 이점을 가질 수 있습니다.

```java
String sql = "select id, name from user wherer name= ?";
PreparedStatment pstmt = conn.prepareStatment(sql);
pstmt.setString(1,name);
ResultSet rs = pstmt.excuteQuery(sql);
```

참고
[https://devbox.tistory.com/entry/Comporison](https://devbox.tistory.com/entry/Comporison)

[https://galid1.tistory.com/492](https://galid1.tistory.com/492)

https://devlog-wjdrbs96.tistory.com/139
