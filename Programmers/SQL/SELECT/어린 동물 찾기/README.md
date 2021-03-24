어린 동물찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59037

<br>

### 풀이

동물 보호소에 들어온 동물 중 젋은동물(WHERE INTAKE_CONDITION = 'Aged')의 아이디와 이름을 조회. 결과는 아이디 순.

~~~SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION !='Aged';
~~~