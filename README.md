# wanted-pre-onboarding-backend
프리온보딩 백엔드 인턴십 선발과제

## 기술 스택
![Java](https://img.shields.io/badge/-Java-FF7800?style=flat&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-flat&logo=spring&logoColor=white)
![SpringBoot](https://img.shields.io/badge/-SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white)
![SpringDataJPA](https://img.shields.io/badge/SpringDataJpa-236DB33F?style=flat&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-%2496ED.svg?style=for-the-flat&logo=docker&logoColor=white)


## 프로젝트 아키텍처
<img width="538" alt="스크린샷 2024-07-17 오후 4 33 04" src="https://github.com/user-attachments/assets/2760c3a0-bab1-4f91-b26a-9b9e9e16f3aa">

## 클래스별 역할
|변수명|설명|
|:---:|:---:|
|XxxCommand|Service 메서드의 처리와 조회를 위한 파라미터|
|XxxInfo|리턴객체 : DB에서 조회하여 가져온 Entity를 그대로 리턴하지 않기 위함|
|XxxStore|도메인의 저장을 담당|
|XxxReader|도메인을 읽어오는 담당|
|XxxFacade|비즈니스 결정을 내리지 않고 수행할 작업을 정의함|
|XxxFactory|객체를 생성하는 일이 복잡해지거나 내부 구조를 너무 많이 드러내는 경우 사용|
