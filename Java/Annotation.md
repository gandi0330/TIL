# Java Annotation


Anooation은 본래 주석이라는 뜻으로 인터페이스를 기반으로 한 문법이다. 

주석과 역할은 다르지만 주석처럼 코드에 달아 클래스에 특별한 의미를 부여하거나 기능을 주입할 수 있다. 

Annotation은 크게 세 가지 종류가 존재한다.

1. jdk에 내장되어있는 built-in annotation
    - 주로 컴파일러에게 유용한 정보를 제공한다.
        
        ```java
        // 메서드 앞에만 붙이며 해당 메서드가 오버라이드 한 메서드임을 컴파일러에 명시한다.
        // 메서드 명을 잘못써도 컴파일러는 잘못쓴건지, 새로운 메서드를 생성한 것인지 알 수 없다.
        // 따라서 어노테이션으로 오타의 발생 가능성을 잡아준다.
        @Override
        
        // 차후 버전에 지원되지 않을 수 있기 때문에 더 이상 사용하지 말아야 할 메서드를 말한다.
        @Deprectated
        
        // 프로그래머의 의도를 컴파일러에게 전달하여 경고를 제거한다.
        @SupressWarning
        
        // 컴파일러에게 다음의 인터페이스는 함수형 인터페이스임을 알린다.
        @FunctionalInterface
        ```
        
2. Meta-Annotation
    - Annotation에 사용되는 Annotation들
3. Custom Annotation
    - 사용자 Annotation

[http://asfirstalways.tistory.com/309](http://asfirstalways.tistory.com/309)
