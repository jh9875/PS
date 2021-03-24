아픈 동물 찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59036

<br>

### 풀이

동물 보호소에 들어온 아픈 동물(WHERE INTAKE_CONDITION = 'Sick')의 아이디와 이름을 조회(SELECT ANIMAL_ID, NAME). 아이디는 역순(ORDER BY )

~~~SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;
~~~