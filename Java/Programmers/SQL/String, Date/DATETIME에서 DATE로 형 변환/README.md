DATETIME에서 DATE로 형 변환
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59414

<br>

### 풀이

모든 레코드에 대해 동물의 아이디, 이름, 들어온 날짜를 조회. 결과는 아이디 순

DATE_FORMAT사용. 날짜 형식을 정할 수 있음.

~~~sql
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, "%Y-%m-%d")
FROM ANIMAL_INS;
~~~
