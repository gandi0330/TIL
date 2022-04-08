# CPU 스케줄링


Ready Queue에 있는 프로세스들을 대상으로 스케줄링 한다(단기 스케줄러)

<br>
<br>

### 선점 비선점 Preemptive, Non-preemptime

- Preemptive 선점
    - CPU가 어느 프로세스를 실행하고 있는데 강제로 쫓아내고 새로운 것이 들어가도록 하는 스케줄링
    - 빠른 응답, 시분할 시스템에 적합
    - 오버헤드 발생
- Non-preemptive 비선점
    - 프로세스가 끝나거나 IO를 만나기 전엔 쫓아낼 수 없음
    - 응답시간 예상 가능, 공정한 처리
    - 짧은 작업이라도 긴 대기시간 때문에 오래걸릴 수 있음

<br>
<br>


### 스케줄링 척도 Scheduling criteria

- CPU Utilization (Cpu 이용률) : Cpu가 얼마나 놀지 않고 일하는지
- Throughput(처리율) : 단위 시간 당 처리한 프로세스 수
- Turnaround time(반환시간) : 작업이 readyQueue 들어가서 나오는 시간 차이
- waiting time(대기시간) : readyQueue에서 기다린 시간
- response time(응답시간) : 작업 요청 후 응답이 오는 데 걸린 시간

<br>
<br>


### CPU 스케줄링 알고리즘

- FCFS(First Come First Served)
    - 특징
        - 도착한 순서대로 처리(일괄처리)
        - 비선점형 스케줄링
    - 단점
        - 한번 프로세스를 CPU에 게 할당하면 CPU burst가 완료될 때까지 CPU를 반환하지 않으므로 짧은 작업이 긴 작업을 기다리게 된다 ( Convoy Effect 호위효과 )
    
- SJF(Shortest Job First)
    - 특징
        - 다른 프로세스가 먼저 도착했어도 CPU burst time이 짧은 프로세스에게 선 할당
        - 비선점형 스케줄링
    - 단점
        - CPU burst time이 아주 긴 프로세스가 영원히 CPU를 할당 받지 못할 수 있다. ( 기아현상 Starvation)

- SRTF(Shortest Remaining Time First)
    - 특징
        - 새로운 프로세스가 도착할 때마다 스케줄링이 이루어짐
        - 선점형 스케줄링
        - 현재 수행중인 프로세스의 남은 burst time보다 더 짧은 burst time을 가진 새로운 프로세스가 도착하면 CPU를 뺏긴다
    - 단점
        - 기아 현상
        - 잦은 선점으로 문맥교환 오버헤드가 증가
        - 
    
- Priority Scheduling
    - 특징
        - 우선순위가 가장 높은 프로세스에게 CPU를 할당
        - 우선순위는 정수로 표현하고 일반적으로는 작은 숫자가 우선순위가 높다
        - 선점형 스케줄링
            - 더 높은 우선순위의 프로세스가 도착하면 실행중인 프로세스를 멈추고 선점
        - 비선점형 스케줄링
            - 더 높은 우선순위의 프로세스가 도착하면 Ready Queue 의 Head에 넣는다
    - 단점
        - 기아 현상
        - Indefinite blocking : 실행 준비는 되어있지만 CPU를 사용 못하는 프로세스가 무기한으로 대기하는 것
    - 해결방법
        - Aging (노화) : 오래 기다릴 수록 우선순위를 높여준다

- Round Robin
    - 특징
        - 각 프로세스는 동일한 크기의 할당시간을 가진다
        - 할당 시간이 지나면 다른 프로세스에게 선점당하고 ready queue의 젤 뒤에 줄을 선다
        - RR 이 가능한 이유는 context를 저장할 수 있기 때문
    - 장점
        - Response time이 빨라진다 → n개의 프로세스가 ready queue에 있고 할당 시간이 q(time quantum)인 경우 각 프로세스는 (n-1)  * q 이상 기다리지 않는다.
        - CPU를 많이 사용할 만큼 대기시간도 증가하기 때문에 공정하다 할 수 있다.
    - 주의할 점
        - time quantum이 너무 커지면 FCFS, 너무 작아지면 문맥교환의 오버헤드가 발생한다
