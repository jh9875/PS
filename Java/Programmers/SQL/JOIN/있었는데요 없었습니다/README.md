있었는데요 없었습니다
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59043

<br>

### 풀이

보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회. 결과는 보호 시작일이 빠른 순으로.

JOIN 후 ANIMAL_INS의 DATETIME과 ANIMAL_OUTS의 DATETIME을 비교한 결과를 반환.

~~~sql
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
INNER JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME
ORDER BY ANIMAL_INS.DATETIME;
~~~