# JVM


>### JVM이란?

Java Virtual Machine 자바 가상 머신은 자바 애플리케이션을 클래스 로더를 통해 읽어들여 자바 API와 함께 실행하는 것이다. 또한 JVM은 Java와 OS 사이에서 중개자 역할을 수행하여 Java가 OS에 구애받지 않고 사용하도록 가능하게 해준다 (WORA). 그리고 메모리 관리, Garbage collection을 수행한다. JVM은 스택기반의 가상머신이다.

<br>
<br>

>### 자바 프로그램 실행 과정

1. 프로그램이 실행되면 JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받는다.
    
    JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.
    
2. 자바 컴파일러(javac)가 자바 코드(.java)를 읽어들여 자바 바이트코드(.class)로 변환시킨다.
3. Class Loader를 통해 class 파일을 JVM으로 로딩한다.
4. 로딩된 class 파일들은 Execution engine을 통해 해석된다.
5. 해석된 바이트코드는 Runtime Data Areas에 배치되어 실직적인 수행이 이루어진다.
    
    이러한 과정에서 JVM은 필요에 따라 Thread Synchronizaiton과 GC같은 관리 작업을 수행한다.
    

<br>
<br>

>### Class Loader(클래스 로더)

JVM내로 바이트코드를 로드하고 링크를 통해 배치하는 작업을 수행하는 모듈

- Runtime시 동적으로 클래스를 로드
- jar파일 내 저장된 클래스들을 JVM위에 탑재하고 사용하지 않는 클래스들은 메모리에서 삭제
- 자바는 컴파일 타임이 아닌 런타임에 참조를 하는데 이는 클래스를 처음 참조할 때 해당 클래스를 로드하고 링크한다는 것이다. 이 역할을 클래스 로더가 수행한다.

<br>
<br>

>### Execution Engine(실행 엔진)

클래스를 실행시키는 역할

클래스 로더가 JVM내의 런타임 데이터 영역에 바이트 코드를 배치시키고, 이를 실행엔진이 실행

자바 바이트 코드는 완전한 기계어가 아니기 때문에 실행엔진이 이를 JVM내부에 기계가 실행할 수 있는 형태로 변경


<br>
<br>

>### Interpreter(인터프리터)

실행 엔진은 자바 바이트 코드를 명령어 단위로 읽어서 실행한다. 한 줄씩 수행하기 때문에 느리다

<br>
<br>

>### JIT(Just In Time)

인터프리터 방식의 단점을 보완하기 위해 도입된 JIT 컴파일러이다. 인터프리터 방식으로 실행하다가 적절한 시점에 바이트 코드 전체를 컴파일하여 네이티브 코드로 변경하고 이를 실행한다.

네이티브 코드는 캐시에 보관하기 대문에 한번 컴파일된 코드는 빠르게 수행할 수 있다.

하지만 JIT컴파일러가 컴파일하는 과정은 인터프리팅보다는 느리기 때문에 한 번만 실행하는 코드라면 인터프리팅이 유리하다. 때문에 JIT 컴파일러를 사용하는 JVM은 내부적으로 해당 메서드가 얼마나 자주 수행되는지 체크하고, 일정 정도를 넘었을 때만 수행한다.

<br>
<br>

>### Garbage collector

GC를 수행하는 모듈이 있다.

<br>
<br>

>### Runtime Data Area

프로그램을 수행하기 위해 OS에서 할당받은 메모리 공간


1) PC Register 

- Thread가 시작될 때 생성되며 각 Thread마다 하나씩 존재
- Thread가 어떤 부분을 어떤 명령으로 실행해야할지 기록된 부분
- 현재 수행중인 JVM  명령의 주소를 가짐

2) JVM 스택 영역

- 프로그램 실행과정에서 임시로 할당되었다 메서드를 빠져나가면 소멸되는 특성의 데이터를 저장하기 위한 영역
- 변수, 임시 데이터, 스레드, 메서드 등을 저장
- 메서드 호출 시 마다 각각의 스택 프레임이 생성되고 메서드가 끝나면 프레임 별로 삭제
- 메서드 안에서 사용되는 지역 변수를 저장하고 매개변수, 리턴 값, 연산 값 들을 임시로 저장

3) Native method stack

- Java가 아닌 다른 언어로 작성된 코드를 위한 공간으로 Java Native Interface를 통해 바이트 코드로 전환하여 저장된다.

4) Method Area (= Class area = Static area)

- 클래스 정보를 처음 메모리 공간에 올릴 때 초기화 되는 대상을 저장하기 위한 메모리 공간
- Field Information : 멤버 변수, 데이터 타입, 접근 제어자
- Method Information : 메서드 이름, 리턴타입, 매개변수, 접근제어자
- Type Information : 클래스인지, 인터페이스인지, 속성, 전체 이름, super class의 이름 등
- 추가로 상수 자료형을 저장하고 중복을 막는 역할인 Runtime Constant Pool도 존재

5) Heap 

- 객체를 저장하는 가상 메모리 영역
- new 연산자로 생성된 객체와 배열을 저장 ( Method area 영역의 데이터로도 객체 생성 가능)
- 힙은 크게 세 부분으로 나뉨
    
    
    - Permanent Generation
        - 생성된 객체 정보의 주소값이 저장된 공간
        - 클래스 로더에 의해 로드되는 클래스와 메서드의 Meta정보가 저장됨
        - Relfection을 사용하여 동적으로 클래스가 로딩되는 경우에 사용됨
    - New/Young Generation
        - Eden : 객체들이 최초로 생성되는 공간
        - Survivor 0 / 1 : Eden에서 GC가 일어난 후 살아남은 객체들이 저장되는 공간
    - Old Generation
        - New/Young Generation에서 일정시간 살아남은 객체들이 저장되는 공간

출처

[https://asfirstalways.tistory.com/158](https://asfirstalways.tistory.com/158)
