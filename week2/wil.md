1️. 스터디 개요
백엔드 & 스프링 입문자 대상 6주 과정
온라인 쇼핑몰 프로젝트를 직접 구현하며 학습
Top-down 방식으로 백엔드 전체 흐름 이해
배경지식: Java, 객체지향, SQL


2️. 계층형 아키텍처 (Layered Architecture)
스프링의 핵심 설계 구조
Controller → Service → Repository → DB 순으로 데이터 흐름

계층 역할 비유
Controller	요청을 받아 서비스로 전달	웨이터
Service	비즈니스 로직 처리	주방장
Repository(DAO)	데이터 접근	창고 관리인
DB	실제 데이터 저장소	냉장고


3️. DTO vs Entity
구분 설명 예시
DTO	필요한 정보만 전달 (데이터 전송용)	주문서, 영수증
Entity	DB와 매핑된 핵심 객체	원재료(한우 등심 등)

※ Entity는 외부에 직접 노출 금지 (보안·일관성 유지)


4️. 컨트롤러 계층 (Controller Layer)
웹 요청의 진입점
HTTP 요청/응답 처리 (JSON 사용)
서비스 계층에 의존하여 로직 실행

주요 어노테이션
@RestController, @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
@RequestBody : JSON 데이터를 객체로 변환


5️. RESTful API 설계 예시
기능	HTTP Method	URI
회원 등록	POST	/members
회원 목록 조회	GET	/members
회원 상세 조회	GET	/members/{memberId}
회원 수정	PATCH	/members/{memberId}
회원 삭제	DELETE	/members/{memberId}

Path Variable 예시: /members/{memberId}

HTTP 상태 코드
200 OK: 요청 성공
201 Created: 생성 성공
204 No Content: 삭제 성공
400 Bad Request: 요청 오류
404 Not Found: 데이터 없음
500 Internal Server Error: 서버 오류

6️. 서비스 계층 (Service Layer)
비즈니스 로직의 중심
Controller ↔ Repository 간 연결
데이터 검증, 수정, 트랜잭션 관리 담당

트랜잭션(Transactional)
모든 동작을 한 단위로 묶어 원자성(Atomicity) 보장
@Transactional 사용 (2주차는 JPA 미사용 → 주석 처리)

작성 방식
생성자 주입 (@Autowired or @RequiredArgsConstructor)
조회 전용 시 @Transactional(readOnly = true) 옵션 사용


7️. 스프링 빈 & 의존성 주입 (Spring Bean & DI)
스프링 컨테이너(Application Context)가 빈(Bean) 관리
공용 객체를 스프링이 자동 생성·주입

주요 어노테이션
@Controller, @Service, @Repository, @Component

의존성 주입(Dependency Injection, DI)
필요한 객체를 외부에서 주입받음 (직접 생성 X)
메모리 효율 ↑, 코드 결합도 ↓, 재사용성 ↑

DI 방법
생성자 주입 (권장) – final + @RequiredArgsConstructor
필드 주입
수정자(Setter) 주입


8️. 패키지 구조
구조 설명 특징
계층형 구조	Controller, Service 등 기능별 분리	전통적 구조
도메인형 구조	도메인별로 모든 관련 클래스 포함	유지보수·확장성 우수
-> 도메인형 구조 권장


- 핵심 요약
스프링은 계층형 구조로 설계되어 유지보수성↑
Controller: 요청 처리 / Service: 비즈니스 로직 / Repository: 데이터 접근
DTO ↔ Entity 분리하여 보안 및 일관성 확보
DI로 객체 의존성 관리, 코드 효율 향상
RESTful API 설계 시 HTTP Method와 URI 구조 중요
