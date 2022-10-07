최솟값 구하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59038

<br>

### 풀이

가장 먼저 들어온 동물 => DATETIME이 가장 작은 값. DATE타입도 집계함수 사용 가능.

~~~SQL
SELECT MIN(DATETIME)
FROM ANIMAL_INS;
~~~

또는 정렬한 후 LIMIT 사용 가능.

~~~SQL
SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
~~~