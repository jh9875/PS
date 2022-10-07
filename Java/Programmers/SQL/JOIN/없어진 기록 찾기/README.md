없어진 기록 찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59042

<br>

### 풀이

문제를 IN 또는 JOIN으로 해결할 수 있다.

1. IN으로 해결하는 경우. <br>
   입양을 간 기록(ANIMAL_OUTS)은 있음. 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID순으로 조회.

   ANIMAL_INS에 없고(NOT IN ANIMAL_INS) ANIMAL_OUTS에 있는 ANIMAL_ID를 찾으면 됨.

	~~~SQL
	SELECT ANIMAL_ID, NAME
	FROM ANIMAL_OUTS
	WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID
        	                FROM ANIMAL_INS
                	        )
	~~~
2. JOIN으로 해결하는 경우. <br>
   LEFT JOIN으로 해결 가능. <br>
   ANIMAL_OUTS 테이블에 ANIMAL_INS 테이블을 LEFT JOIN 한 후 ANIMAL_INT.ANIMAL_ID가 NULL인 것을 출력 (ON 조건절이 맞지 않으면 ANIMAL_INS테이블의 필드가 NULL 이므로.)

   ~~~sql
   SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME
   FROM ANIMAL_OUTS
   LEFT JOIN ANIMAL_INS
   ON ANIMAL_OUTS.ANIMAL_ID = ANIMAL_INS.ANIMAL_ID
   WHERE ANIMAL_INS.ANIMAL_ID IS NULL;
   ~~~

