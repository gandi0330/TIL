#EC2

<br>
<br>

## EC2 info
- Elastice Compute Cloud
- 가상머신 사용가능(EC2 instance)
- 가상드라이브 저장(EBS Volumn)
- 로드분산(ELB)
- 오토 스케일링 그룹을 통해 서비스 확장(ASG)

## sizing, option
- OS설정
- CPU
- RAM
- 저장장치
- IP
- security group
- Bootstrap script 

## EC2 User Data
- EC2사용자 데이터 스크립트를 사용하여 Bootstrap 가능
-Bootstrap은 머신이 작동될 때 명령을 시작하는 것
- Bootstrap script는 머신이 처음 작동될 때 한번만 실행됨
- 보통 업데이트, 소프트웨어 등등 이있다.
- 루트 계정에서만 실행된다

## EC2 인스턴스 종류
- t2.micro
- t2.xlarge
- c5d.4xlarge
- r5.16xlarge
- m5.8xlarge

- t : instance class, 2 : generation, .micro : size with the instance class

- General Purpose
  - 컴퓨팅, 메모리, 네트워킹이 균형화되어있어 범용으로 사용한다 웹서버, 코드 레포지토리 등
- Compute Optimized
  - 고성능 프로세스라 배치프로세싱, 미디어, 고성능 웹서버, 고성능 컴퓨팅(HPC), 모델링, 머신러닝, 게이밍최적화 등으로 사용
  - c로 시작
- Memory Optimized
  - 대용량 데이터 접근이 빠르다
  - 데이터베이스, 인메모리 데이터베이스 , BI, 실시간 어플리케이션, 비정형데이터
  - r로 시작
- Storage Optimized
  - 로컬 스토리지에서 대규모 데이터셋에 액세스할 대 적합한 인스턴스
  -  OLTP, NoSQL, Redis, 데이터 웨어하우징, 분산파일시스템
  - I G H1


## Security Group
- EC2 의 방화벽
- 보안그룹은 규칙을 가진다
- 해당 규칙은 inbound traffic, outbound traffic

- 포트로 액세스를 통제, 인증된 IP범위를 확인해 IPv4, IPv6인지 확인, 인스턴스로 들어오거나 나가는 트래픽을 검증

- 일반적으로 SSH 접근을 위한 보안그룹은 따로 만드는 것이 좋다
- 기본적으로 모든 인바운드 트래픽은 차단되어있고, 아웃바운드는 풀려있다

## Classic port
- 22 = SSH (Secure Shell)
- 21 = FTP (File Transfer Protocol) 업로드 파일
- 22 = SFTP (Secure File Transfer Protocol) 시큐어쉘로 업로드 가능
- 80 = HTTP - access unsecure websites
- 443 = HTTPS - access secured websites
- 3389 = RDP - remote Desktop Protocol 


## SSH Summary Table
- SSH : Max, linux, window>=10
- Putty : window
- EC2 instance connect : all


## EC2 접속
- EC2인스턴스에 개인 accesskey를 넣는 것은 보안상으로 부적절하다
- 대신 IAM Role를 설정하여 권한을 허용할 수 있다
- IAM Role 생성->권한 부여->인스턴스에 Role 설정

## EC2 인스턴스 구매 플랜
- On-Demand Instances : 짧은 워크로드를위한 인스턴스, 초당 가격조회 가능, 가격 예측 가능, 사용한 만큼 가격 측정
- Reserved : 긴 워크로드를 위한 인스턴스, 인스턴스 전환형도 있음, 선결제인 대신 가격할인이 많음, 전환형은 가격할인이 덜함
- Saving Plans : 긴 워크로드에 사용량에 따른 플랜, 특정한 지불액 자체를 약정으로 거는 것
- Spot Instances : 짧은 워크로드, 인스턴스를 잃을 수 있어 신뢰성 떨어짐, 할인율이 제일 큼, 가격을 넘으면 인스턴스가 손실됨->db에는 부적절함
- Dedicated Instances : 온전히 인스턴스를 다른사람과 공유하지 않고 사용 (인스턴스는 전용 하드웨어를 가지는 것, 호스트는 물리적서버 자체에 대한 접근권과 낮은수준의 인스턴스 정보를 가지는 것) 
- Dedicated Host: 온전히 전체 물리적 서버를 예약하여 인스턴스를 관리하는 것 (라이선스문제 등 전용 호스트가 피요할 때 사용, 젤 비쌈)
- Capacity Reservations : 원하는 기간동안 특정 용량을 예약하는 것 (특정 용량을 예약하는 거라 사용중이지 않을때도 비용이 청구되기 때문에 단기적이고 연속적인 워크로드에 적합)


## 스팟플릿
- 여러 런치 풀과 여러 인스턴스 유형을 정의할 수 있다
- 오로지 전력 비용만 생각하면 됨
- 자동으로 가장 낮은 가격의 스팟 인스턴스를 요청
- 때문에 추가적으로 비용을 절감할 수 있음

- 그냥 스팟인스턴스를 요청할 때는 인스턴스 유형등을 정확히 알고 있을 경우에 해야되고, 아니면 스팟플릿 사용

- 가장 낮은 가격인 풀에서 인스턴스를 시작하는 경우 가격절감이 최대화됨, 워크로드가 짧을 대


## EC2 배치 그룹
- Placement Groups Cluster
    - 랙이 물리적으로 한곳에 있어 네트워크 속도와 빅데이터 작업 가능
    - 하지만 위험
- Placement Group Spread
    - 물리적으로도 분리가 되어있음, 배치당 인스턴스 분산 개수 최대는 7개로 제한되어있음
- Plcaements Group Partition
    - 파티션으로 나누고 랙을 넣음, EC2인스턴스를 많이 얻을 수 있고, 파티션별로 문제가 생겼을 때 다른 파티션을 보호할 수 있음
    - HDFS HBase, Cassandra, Kafka
