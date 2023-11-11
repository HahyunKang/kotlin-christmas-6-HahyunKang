# 미션 - 크리스마스 프로모션

## 🔍 기능목록 정리
1. 메뉴 종류 별로 정리
- 종류 별로 메뉴 이름과 가격을 어떻게 관리할지 고민!
- enum class와 const를 활용해보자

2. 입력 처리
- 예상 방문 날짜
- 주문할 메뉴와 개수

3. 입력 예외 처리 -> 모든 메시지는 [ERROR]로 시작
-> ENUM CLASS로 관리 시도
- 방문 날짜 입력 시 1~31의 숫자만 입력 가능
- 메뉴 개수는 1 이상의 숫자만
- 메뉴 형식이 다르면 예외 처리
- 중복 메뉴 입력 시 예외 

4. 이벤트 처리 -> 총 주문 금액/각 메뉴/각 날짜 당 할인인지 구분 필요
   1. 크리스마스 디데이 할인(1일에서 25일까지만)
   - 1000원, 1100원, 1200원 같이 100원씩 할인 금액 증가
   - **총 주문** 금액에서 할인
   2. 평일(일,월,화,수,목) - 디저트 1개 당 2023원 할인
   - **메뉴** 당 할인
   3. 주말(금,토) - 메인메뉴 1개 당 2023원 할인
   - **메뉴** 에서 할인
   4. 특별 할인 - 달력에 별이 있다면 할인
   - **날짜** 에서 할인(3,10,17,24,25,31)
   5. 증정 이벤트 - **할인 전** 주문 금액이 12만원 이상일 시 샴페인 1개 증정
   - **총 주문 금액**에서 25000원 할인
   6. 배지 이벤트
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타
   

5. 할인 금액 정리
- 입력된 날짜와 메뉴를 정리해 할인 내역 정리
- 할인 내역을 바탕으로 할인 금액 정리
- 하나라도 빠트리지 않도록 주의

6. 이벤트 결과 출력
- 주문메뉴
- 할인 전 총 주문 금액
- 증정 메뉴
- 혜택 내역
- 총 혜택 금액
- 할인 후 예상 결제 금액
- 12월 이벤트 배지

## 🚀 코드 리뷰에서 받은 피드백 
1. 불필요한 공백 제거
2. 에러 메시지 함수 분리-> 어떤 에러인지 함수로 알기 쉽게 구분
3. 변수명으로 자료형 사용 x 
4. 넘버 상수화

## ✏️ 고민 POINT