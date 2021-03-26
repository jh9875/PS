이름이 없는 동물의 아이디
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59039

<br>

### 풀이

동물 보호소에 들어온 동물 중, 이름이 없는 채로 들어온 동물의 ID를 조회. ID는 오름차순.

이름이 없다 => NULL이다. => WHERE NAME IS NULL

ID 오름차순 => 기본적으로 아이디 오름차순으로 되어있음. => 생략 가능.

~~~SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL;
~~~