## IAM 


## IAM Polices inheritance
- JSON 파일로, 유저 혹은 그룹에 정책을 부여할 수 있다
- sid, effect, principal, action, resource, condition

## IAM - Password Policy
- 패스워드 정책 설정 가능
- 최소문자, 구체적인 문자 타입, 언제바꿀지, 몇개 이전의 비밀번호로 변경 불가능하게 설정할 지

## IAM - Multi Factor Authentication 
- password + security device 로 계정을 보호하는 방식
- 가상방식(어플 등)과 물리 방식(usb키)등이 존재

## IAM Roles for Services 

- AWS 인스턴스가 AWS에 접근하기 위해서는 IAM Role이 필요하다.
- 일반적인 IAM Role
  - EC2 instance Roles
  - Lambda Function Roles
  - Roles for CloudFormation

- Role 설정 방법
  - Role 생성 + Role에 대해 정책과 권한 설정

## IAM Security Tools

- IAM Credentials Report (account-level)
  - csv 파일 
  - 비밀번호 변경 언제했는지, 활성화여부, 액세스키, 비밀번호 정책에 따른 다음 변경 주기 등  -> 사용자 계정 정보 확인 가능
- IAM Access Advisor (user-level)
  - 마지막에 사용한 서비스 확인
  - 보통 4시간동안 액세스 한 서비스에 대한 것을 보여줌


## IAM Guidelines, Best practices
- AWS account를 설정하는것이 아니라면 root계정 사용하지 않기
- 하나의 물리적 사용자별로 사용자계정 부여하기
- 유저를 그룹에 할당하고, 그룹별 권한 허용하기
- 강력한 비밀번호 정책 사용하기
- MFA(Multi Factor Authentication)을 사용하여 보안 강화하기
- AWS 서비스마다 역할 및 권한을 부여하기
- CLI / SDK를 사용할 경우 액세스키를 만드는데 기밀로 하기
- 계정의 권한을 감시할 때는 IAM 자격증명보고서와 IAM 액세스분석기를 사용

## IAM Summary
- Users : 물리적 유저를 매핑시킬 수 있고 AWS콘솔에 접근 가능
- Groups : 유저를 포함하는 그룹 생성 가능, 그룹이 그룹을 포함 시키진 못함
- Polices : JSON 문서로 유저나 그룹의 정책을 설정 가능
- Roles : AWS 서비스 (EC2같은) 에 대한 역할 부여
- Security : MFA + Password Policy
- AWS CLI : AWS services command line
- AWS SDK : AWS services programming language
- Access Keys : CLI, SDK 접속 키
- Audit : IAM Credential Reports, IAM Access Advisor
