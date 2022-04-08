# Java의 Garbage Collection

### Garbage Collection?

자바는 메모리를 할당한 뒤 따로 해제하지 않는다. 대신 JVM의 Garbage Collector가 더 이상 참조되지 않는 객체를 해제하는 역할을 한다.

<br>
<br>


### Minor GC

새로 생성된 객체가 저장되는 영역인 Eden에서 GC가  한 번 발생한 후 살아남은 객체는 Survivor 영역 중 하나로 이동하게 된다. 이 과정을 반복하다가 계속해서 살아남아 있는 객체는 일정시간 참조되고 있다는 뜻으로 Old 영역으로 이동하게 된다.

<br>
<br>

### Major GC

Old영역에 있는 모든 객체들을 검사하여 참조되지 않은 객체들을 한꺼번에 삭제한다.

시간이 오래 걸리고, 실행 중에 프로세스가 정지되는 데 이를 “stop-the-world”라고 한다.

MajorGC가 발생하면 GC를 실행하는 스레드를 제외한 나머지 스레드는 모두 작업을 멈춘다.

<br>
<br>

### Garbage Collection 원리

알고리즘에 따라 동작 방식이 매우 다양하지만 공통적인 원리가 있다.

힙 내의 객체 주에서 Garbage를 찾아내고, 해당 Garbage를 처리하여 힙의 메모리를 회수한다.

참조되고 있지 않은 객체를 Garbage라 하며 해당 객체가 Garbage인지 아닌지를 판단하기 위해서 reachability라는 개념을 사용한다.

어떤 힙 영역에 할당된 객체가 유효한 참조가 있으면 reachability, 없으면 unreachability로 판단한다.

하나의 객체는 다른 객체를 참조하고,, 이는 참조 사슬을 형성하는데 이 중 최초에 참조한 것을 Root Set이라고 한다. 

객체가 Garbage가 되었다고 바로 소멸되는 것은 아니다. 빈번한 GC는 시스템에 부담되기 때문에 별도의 알고리즘을 기반으로 실행된다.

→ Serial GC, Parallel GC..등등
