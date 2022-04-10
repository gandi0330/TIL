# Java Collection


Java에서 컬렉션(Collection)은 데이터의 집합, 그룹을 의미하며 

JCF(Java Collections Framework)는 이러한 데이터, 자료구조인 컬렉션과 이를 구현하는 클래스를 정의하는 인터페이스를 제공한다.

Collection 인터페이스는 크게 List, Set Map로 분류한다.

Map의 경우도 Collection 인터페이스를 상속받진 않았지만 Collection으로 분류한다.

<br>
<br>

### Collection을 사용하는 이유

- 다수의 Data를 다루는데 표준화된 클래스들을 제공해주기 때문
- 자료구조를 직접 구현하지 않고 편하게 사용하기 위해
- 객체의 보관을 위한 공간을 미리 설정하지 않아도 되므로 프로그램의 공간적인 효율성을 높여준다.

<br>
<br>

### Collection 인터페이스 종류

- List
    - 순서가 있는 데이터의 집합으로 데이터의 중복을 허용한다.
    - LinkedList
        - 양방향 포인터 구조로 데이터의 삽입, 삭제에서 O(1)
        - 스택, 큐, 덱 만들 때 주로 사용
    - Vector
        - 과거에 대용량 처리를 위해 사용했으며, 내부적으로 자동 동기화가 일어남
    - ArrayList
        - 단방향 포인터 구조로 각 데이터에 대한 인덱스를 가지고 있어 조회 성능이 뛰어남

- Set
    - 순서를 유지하지 않는 데이터의 집합으로 데이터의 중복을 허용하지 않는다.
    - HashSet
        - 가장 빠른 임의 접근속도
        - 순서를 예측할 수 없음
    - TreeSet
        - 정렬방법을 지정할 수 있음

- Map
    - key, value가 쌍으로 이루어진 데이터 집합으로 순서는 유지되지 않으면 key의 중복을 허락하지 않으나 value의 중복은 허용한다.
    - Hashtable
        - HashMap보다는 느리지만 동기화를 지원
        - null 불가
    - HashMap
        - 중복이 허용되지 않고 순서가 없으며 null값이 올 수 있음
    - TreeMap
        - 정렬된 순서대로 key와 value를 저장하여 검색이 빠름
