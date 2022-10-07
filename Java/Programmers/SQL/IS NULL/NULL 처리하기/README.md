NULL 처리하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59410

<br>

### 풀이

동물의 생물 종, 성멸, 중성화여부를 아이디 순으로 조회. 이때 이름이 없는 동물의 이름은 "No name"으로 표시

이름이 없으면 "No name"으로 표시 => 조건문을 사용해야함.

IFNULL(값1, 값2) => 값1이 NULL이면 값2를, 아니면 값1을 사용.

~~~SQL
SELECT ANIMAL_TYPE, IFNULL(NAME, "No name"), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
~~~