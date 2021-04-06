보호소에서 중성화한 동물
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59045

<br>

### 풀이

보호소에 들어올 당시에는 중성화되지 않았지만, 나갈 당시에 중성화된 동물의 아이디, 생물 종, 이름을 조회.

ANIMAL_INS와 ANIMAL_OUTS를 JOIN한 후 ANIMAL_INS.SEX_UPON_INTAKE가 Itact로 시작하면서 <br>
ANIMAL_OUTS.SEX_UPON_OUTCOME이 Spayed 또는 Neutered로 시작하는 동물을 조회. 

~~~sql
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.ANIMAL_TYPE, ANIMAL_INS.NAME
FROM ANIMAL_INS
INNER JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.SEX_UPON_INTAKE LIKE 'Intact%' AND (ANIMAL_OUTS.SEX_UPON_OUTCOME LIKE 'Spayed%' OR ANIMAL_OUTS.SEX_UPON_OUTCOME LIKE 'Neutered%');
~~~