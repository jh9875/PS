동물의 아이디와 이름
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59403

<br>

### 풀이

모든 동물(WHERE 조건 없음)의 아이디와 이름(SELEECT ANIMAL_ID, NAME)을 ANIMAL_ID 순 조회.

~~~SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INSS
ORDER BY ANIMAL_ID;
~~~