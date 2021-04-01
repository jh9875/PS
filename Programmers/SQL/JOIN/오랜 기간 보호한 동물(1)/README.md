오랜 기간 보호한 동물(1)
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59044

<br>

### 풀이

입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회. 결과는 보호 시작일 순으로 조회.

ANIMAL_INS에 있지만 ANIMAL_OUTS에 없는 동물. <BR>
=> ANIMAL_INS에 ANIMAL_OUTS를 LEFT JOIN하고, ANIMAL_OUTS가 NULL인 경우.

~~~sql
SELECT ANIMAL_INS.NAME, ANIMAL_INS.DATETIME
FROM ANIMAL_INS
LEFT JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_OUTS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_INS.DATETIME
LIMIT 3;
~~~