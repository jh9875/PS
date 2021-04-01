오랜 기간 보호한 동물(2)
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59411

<br>

### 풀이

입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회. 결과는 보호 기간이 긴 순으로 조회.

ANIMAL_INS와 ANIMAL_OUTS를 JOIN 한 다음 두 DATETIME의 차이 순으로 정렬하면 됨. 날짜 차이는 DATEDIFF를 사용.

~~~sql
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
INNER JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
ORDER BY DATEDIFF(ANIMAL_INS.DATETIME, ANIMAL_OUTS.DATETIME)
LIMIT 2;
~~~
