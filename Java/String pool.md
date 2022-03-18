# String pool (수정중)


```java
String s1 = new String("Hello");
String s2 = new String("Hello");

// String 객체생성시 heap 메모리에 각자 저장되어 주소가 다르다
// s1 == s2 비교 시 주소를 비교하기 때문에 false, equals는 값을 비교하기 때문에 
// true를 반환한다
System.out.println((s1==s2) + " : " + s1.equals(s2));

// String 객체가 아닌 그냥 정의 시 heap 메모리의 String pool에 저장된다
// 이 때 Stirng pool은 hash 뭐시기이기 때문에 중복이 불가능 하여 같은 주소값을 
// 가지게 된다
s1 = "Hello"; // 리터럴
s2 = "Hello";

// 따라서 s1 == s2 주소값은 같아 true, equals 도 true
System.out.println((s1==s2) + " : " + s1.equals(s2));
```
