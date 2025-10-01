1. 웹(Web)이란?
인터넷 상에서 정보를 주고받는 시스템
웹 브라우저를 통해 사용자와 서버가 HTML, 이미지, 동영상 등을 주고받으며 상호작용

구성 요소
클라이언트(Client) : 사용자 측, 브라우저 등
서버(Server) : 요청을 처리하고 데이터를 제공
프로토콜(Protocol) : 통신 규칙

2. HTTP(HyperText Transfer Protocol)
웹에서 데이터를 주고받는 통신 규약

특징
요청(Request) / 응답(Response) 구조

Stateless(상태 비저장) : 요청 간 서버가 상태를 기억하지 않음
주요 HTTP 메서드

Method	설명
GET	데이터 조회
POST	데이터 생성
PUT	데이터 수정(전체)
PATCH	데이터 수정(부분)
DELETE	데이터 삭제

3. API와 REST API
API(Application Programming Interface) : 프로그램끼리 서로 기능/데이터를 주고받는 통로
REST API
HTTP를 이용하여 자원(Resource) 기반으로 데이터를 처리하는 API

특징
URI로 자원을 명시 (/products, /orders/{id})
HTTP 메서드로 동작 구분 (GET, POST, PUT, DELETE)
상태 비저장(stateless)
JSON 등으로 데이터 주고받음

4. Spring Boot
Java 기반 프레임워크로, 웹 애플리케이션과 REST API 개발을 쉽게 만들어줌

특징
빠른 초기 설정 (Starter 패키지 제공)
내장 서버 지원 (Tomcat)
REST API 구현 시 컨트롤러, 서비스, 레포지토리 구조를 쉽게 구성 가능


웹은 정보를 주고받는 시스템, HTTP는 통신 규약, REST API는 HTTP 기반 자원 처리 API, Spring Boot는 쉽게 REST API를 구현할 수 있는 Java 프레임워크임


온라인 쇼핑몰 API 명세서

| 기능          | HTTP Method | URI                   |
| ----------- | ----------- | --------------------- |
| 상품 등록       | POST        | /products             |
| 상품 목록 조회    | GET         | /products             |
| 개별 상품 정보 조회 | GET         | /products/{productId} |
| 상품 정보 수정    | PUT         | /products/{productId} |
| 상품 삭제       | DELETE      | /products/{productId} |

| 기능          | HTTP Method | URI               |
| ----------- | ----------- | ----------------- |
| 주문 생성       | POST        | /orders           |
| 주문 목록 조회    | GET         | /orders           |
| 개별 주문 정보 조회 | GET         | /orders/{orderId} |
| 주문 취소       | DELETE      | /orders/{orderId} |
