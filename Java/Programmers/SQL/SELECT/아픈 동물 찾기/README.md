역순 정렬하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59035

<br>

### 풀이

모든 동물의 (where 조건 없음) 이름과 보호 시작일(SELECT NAME, DATETIME)을 조회, ANIMAL_ID 역순 (ORDER BY ANIMAL_ID DESC)

~~~SQL
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;
~~~