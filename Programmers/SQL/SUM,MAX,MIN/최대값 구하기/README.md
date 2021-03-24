최대값 구하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59415

<br>

### 풀이

가장 최근에 들어온 동물 => DATETIME이 가장 높은 값. DATE타입도 집계함수 사용 가능.

~~~SQL
SELECT MAX(DATETIME)
FROM ANIMAL_INS;
~~~

또는 정렬한 후 LIMIT 사용 가능.

~~~SQL
SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME DESC
LIMIT 1;
~~~