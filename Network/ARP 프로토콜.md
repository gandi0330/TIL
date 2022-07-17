# ARP가 하는 일
- 같은 네트워크 대역에서 통신을 하기 위해 IP주소로 MAC주소를 알아내는 프로토콜
- 같은 네트워크 대역에서 통신하더라도 7계층부터 캡슐화하여 보내기 때문에 IP 주소와 MAC주소가 모두 필요

# ARP 프로토콜의 구조
- 28 Bytes
- Source Hardware Address : 출발지 MAC 주소 6Bytes
- Source Protocol Address : 출발지 IPv4 4Bytes
- Destination Hardware Address : 목적지 MAC 주소 6Bytes
- Destination Protocol Address : 목적지 IPv4 4Bytes
- Hardware type : 2계층 프로토콜(일반적으로 이더넷) 2Bytes
- Protocol type : 3계층 프로토콜(일반적으로 IPv4) 2Bytes
- Opcode : 현재 이 ARP 프로토콜로 요청하고 있는건지, 응답인지 구분 2Bytes
- Hardware Address Length, Protocol Address Length 각 2Bytes
