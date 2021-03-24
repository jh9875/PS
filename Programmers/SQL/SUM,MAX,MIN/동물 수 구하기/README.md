동물 수 구하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59406

<br>

### 풀이

동물 보호소에 동물이 몇 마리 들어왔는지 조회.

모든 동물의 수 => 집계함수 COUNT 사용. 단 COUNT 대상이 NULLABLE이 FALSE 인 필드 사용.

~~~SQL
SELECT COUNT(ANIMAL_ID)
FROM ANIMAL_INS;
~~~