# Getting Started

### 개발프레임워크
- SpringBoot 1.5.3 RELEASE
- JDK 1.8
- JPA
- H2 Embedded memoryDb
- SpringBoot Embedded Tomcat

### 문제해결전략
- 파일 : 서버개발_사전과제3_주택금융신용보증_금융기관별_공급현황.csv 파일 업로드해서 DB에 저장
       C:\yesbe 디렉토리로 업로드
- DB 설계 : 연도, 월 , 기관코드, 금액 으로 하여 기관이 추가로 공급할 때 확장성 고려
                  기관코드, 기관명 설계
- API : restful 사용           
       
### 빌드 및 실행방법
* spring boot Run As> Spring Boot App 실행
* server.port : 8088

1. 데이터 파일에서 각 레코드를 데이터베이스에 저장하는 API 개발
- URL : <http://localhost:8088/biz/house/registData>
- Method : POST
- Content-Type : json/appilcation
|NAME | TYPE | Required | Description |
|---|:---:|---:|---:|
| `dataFile` | File | M | 서버개발_사전과제3_주택금융신용보증_금융기관별_공급현황.csv 파일 업로드 |

2. 주택금융 파일에서 각 레코드를 데이터베이스에 저장하는 API 개발
- URL : <http://localhost:8088/biz/house/registBanks>
- Method : PUT
- Content-Type : json/appilcation

3. 년도별 각 금융기관의 지원금액 합계를 출력하는  API 개발
- URL : <http://localhost:8088/biz/house/getHouseTotalAmountOfYear>
- Method : GET
- Content-Type : json/appilcation

4. 각 년도별 각 기관의 전체 지원금액 중에서 가장 큰 금액의 기관명을 출력하는 API 개발
- URL : <http://localhost:8088/biz/house/instituteOfMaxAmount>
- Method : GET
- Content-Type : json/appilcation
|NAME | TYPE | Required | Description |
|---|:---:|---:|---:|
| `fromYear` | String |  | 기본값 : 2005 |
| `toYear` | String |  | 기본값 : 2017 |

5. 전체년도(2005~2016)에서 외환은행 지원금액 평균 중에서 가장 작은 금액과 큰 금액을 출력하는  API 개발
- URL : <http://localhost:8088/biz/house/instituteOfAvgAmount>
- Method : GET
- Content-Type : json/appilcation
