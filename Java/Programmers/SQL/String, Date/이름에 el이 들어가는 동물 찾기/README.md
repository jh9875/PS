이름에 el이 들어가는 동물 찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59047

<br>

### 풀이

이름에 "EL"이 들어가는 개의 아이디와 이름을 조회. 결과는 이름순.

개를 찾아라 => ANIMAL_TYPE = 'Dog'
이름에 EL이 들어감 => NAME LIKE '%EL%'

~~~sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE "%EL%"
ORDER BY NAME;
~~~