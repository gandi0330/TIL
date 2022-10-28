## SQL Injection

- OWASP Top 10 중 첫 번째에 속해 있으며, 공격이 쉽고 큰 피해를 입힐 수 있습니다.
- 임의의 SQL문을 주입하고 실행되게 하여 데이터베이스가 비정상적인 동작을 하도록 조작하는 행위입니다.

<br>
<br>

## 공격 종류 및 방법

- 논리적 에러를 이용한 SQL Injection
```SQL
SELECT * FROM Users WHERE id = `INPUT1` AND password = `INPUT2`
-- INPUT1에 '`OR 1=1 --'을 입력할 시 

SELECT * FROM Users WHERE id = `` OR 1=1 -- AND password = `INPUT2`
```

<br>
<br>


- Union 명령어를 이용한 SQL Injection
```SQL
SELECT * FROM Board WHERE title LIKE `%INPUT1%` OR contents `%INPUT2%`
-- INPUT1에 '`UNION SELECT null,id,password FROM Users --'를 임력할 시

SELECT * FROM Board WHERE title LIKE `%` UNION SELECT null, id, password FROM Users --%` OR contents `%INPUT2%`
```

<br>
<br>

- Boolean based SQL
```SQL
SELECT * FROM Users WHERE id = `INPUT1` AND password = `INPUT2`

SELECT * FROM Users WHERE id = `abc123` and 
ASCII(SUBSTR(SELECT name FROM information_schema.tables WHERE wable_type=`base table` limit 0, 1)1, 1)) > 100 - ` AND password = `INPUT2`

-- SQL Injection이 가능한 로그인 폼을 통해 악의적인 사용자가 임의로 가입한 abc123이라는 아이디로 다음의 구문을 주입하여 테이블 명을 알아내는 기법이다.
```

<br>
<br>

- Time based SQL

```SQL
SELECT * FROM Users WHERE id = `INPUT1` AND password = `INPUT2`

SELECT * FROM Users WHERE id = `abc123` OR (LENGTH(DATABASE())=1 AND SLEEP(2)) -- ` AND password = `INPUT2`
--데이터 베이스의 길이를 알아내는 기법이다.
```

<br>
<br>

- Stored Procedure SQL Injection
- Mass SQL Injection

<br>
<br>

## 대응 방안

1. 입력 값에 대한 검증
  - 사용자의 입력 값에 대한 검증이 필요한데 서버 단에서 블랙리스트 기반으로 검증할 시 수많은 차단 리스트를 등록해야 하고, 이는 실수가 발생할 수 있다.
  - 특히 주요 키워드를 공백으로 바꾸는 방법은 'SESELECTLECT' 라는 단에서 SELECT를 공백으로 바꾼다면 'SELECT' 키워드가 완성된다.
  - 때문에 공백 대신 의미없는 단어로 치환되어야 한다.
  
  <br>
  
2. Prepared Statement 구문 사용
  - Prepared Statement 구문을 사용하면 사용자의 입력 값이 데이터베이스의 파라미터로 들어가기 전에 DBMS가 미리 컴파일 하여 실행하지 않고 대기.
  - 그 후 사용자의 입력 값을 문자열로 인식하여 공격자의 의도대로 작동하지 않는다.

<br>

3. Error Message 노출 금지
  - 공격자가 SQL Injection을 하기 위해 필요한 데이터 베이스 정보를 주지 않아야 한다.
  - 데이터베이스 에러 발생 시 에러 쿼리문과 에러 내용을 반환하지 않고 사용자에게 보여줄 페이지를 따로 제작한다.
  
  <br>
  
4. 웹 방화벽 사용
