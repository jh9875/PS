이름이 있는 동물의 아이디
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59407

<br>

### 풀이

이름이 없는 동물의 아이디 문제랑 거의 똑같다. 다만 이름이 있는 동물의 ID를 조회 해야 하므로 IS NOT NULL을 사용한다.

~~~SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;
~~~