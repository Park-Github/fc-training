# Fastcampus 사전 과제

## 과제 내용
* 웹 개발에 입문에 필요한 Http,  Rest API 에 대한 기초지식 학습 
* 강의 내의 Spring Boot와 MySQL을 활용한 간단한 웹서비스 실습하기 (클론 코딩)

## 과제 목표
* 백앤드 개발에 필요한 웹 기초 지식을 알고, 필수적으로 사용하는 개발툴과 프레임워크에 대한 입문을 위해 강의를 학습하며 웹 서비스를 구현해본다.

## 개발 도구
- IntelliJ IDEA
- Spring Framework
- Mysql
- Java 
- - -
## Ch.00 - 개발 환경 설치

### 학습 내용 
    - IntelliJ IDE 설치 및 세팅 방법
    - Spring Initializr 를 사용한 Spring Project 생성법

### 프로젝트 경로 
  - /helloWorld
- - -
## Ch.01 - Web & HTTP 개론

### 학습 내용
    - Web의 정의
    - HTTP Protocol / HTTP Method / HTTP status code
    - URI / URL / HTML
    - REST API
    - OSI 7 Layers

### 프로젝트 경로
- - -
## Ch.02 - REST API 실습

### 학습 내용
    - 간단한 GET / POST / PUT / DELETE API 설계
    - Postman API 테스트 프로그램으로 설계한 API 테스트

### 구현 기능
    Rest API(GET, POST, PUT, DELETE)

### 프로젝트 경로 
- /rest-api
- - -
## Ch.03 - Spring Framework의 여러 기능 학습

### 학습 내용
    - Spring에서 Client로 Response를 보내는 방법
      - String, Object, ResponseEntity, @ResponseBody
      - status code 설정

    - ObjectMapper의 역할
      - Client의 Json - Server의 DTO 변환

    - Exception 처리 방법
      - Rest API 에서 발생한 예외를 예외 처리용 클래스에서 처리
        - @RestControllerAdvice
          - RestController 에서 발생한 예외를 감지하는 클래스
        - @ExceptionHandler
          - 예외를 처리할 메소드
        - 예외를 대비하기 위한 API(클래스) 설계법
          - 데이터를 통신 할 Generic 타입의 필드
          - HTTP code , HTTP message를 보낼 필드
        - 예외처리 우선순위 지정 방법
          - @Order

    - Spring Validation
      - 필드 검증 어노테이션
        - @Size, @NotNull, @NotBlank, @NotEmpty ...

      - 검증할 Request Data
        - @Valid

      - BindingResult
        - 검증 오류가 났을 때 오류 정보를 담는 객체

### 구현 기능
      여러 타입의 데이터 응답하기
        - String, Object, ResponseEntity
      
      예외처리 기능

      사용자 정보 유효성 검증 기능
### 프로젝트 경로 
- /rest-api
- /exception
- /validation
- - -
## Ch.04 - Memory Database CRUD 구현

### 학습 내용
    - 구조 : Repository - > DataRepository -> SimpleDataRepository
    - CREATE
    - READ
    - UPDATE
    - DELETE
    
### 프로젝트 경로 
- /memorydb

### 구현 기능
      메모리에 사용자 DB 구현
        - 사용자 정보 생성
        - 사용자 정보 읽기
        - 사용자 정보 갱신
        - 사용자 정보 삭제
- - -
## Ch.05 - MySQL 설치 및 쿼리 실습

### 학습 내용
    - docker 설치, 컨테이너 설정
    - SQL
      - CREATE / INSERT / UPDATE / SELECT / DELETE
      - Data Type

### 프로젝트 경로 
- /docker-compose
- - -
## Ch.06 - ORM

### 학습 내용
    - ORM의 개념
    - Spring Data JPA의 구조
      - Hibernate > JPA > Spring Data JPA
    - Spring Data JPA 사용 방법
      - JpaRepository 인터페이스 구현
      - @Entity로 객체 맵핑

### 프로젝트 경로 
- /jpa
- - -
## Ch.07 - Memory DB -> JPA Migration

### 학습 내용
    - JPA , Mysql dependency 추가
      - application.properties 작성
      - settings.gradle 수정
    - 기존 Repository 인터페이스 제거 
    - JpaRepository 사용
    - 쿼리 작성법
      - JPA 쿼리 메소드 사용
      - 메소드 이름만으로 JPQL 문법을 사용 할 수 있음
      - SQL 쿼리문 직접 작성
      - @Query("sql")

### 프로젝트 경로 
- /memorydbToJpa
- - -
## Ch.08 - 게시판 시스템 설계 및 구현

### 학습 내용
      - ERD 설계
      - JPA 연관관계 설정
        @OneToMany, @ManyToOne
      - Paging 구현법
   
### 구현 기능
      게시판 기능
        - 게시글 조회 , 작성, 삭제 
        - 페이징 기능
### 프로젝트 경로 
- /simple-board
- - -
