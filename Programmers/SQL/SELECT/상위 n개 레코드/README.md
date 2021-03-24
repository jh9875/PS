상위 n개 레코드
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59405

<br>

### 풀이

동물 보호소에 가장 먼저 들어온 동물의 이름을 조회.

가장 먼저 들어온 => DATETIME를 ASC 순으로 정렬했을 때 가장 위에 있는 한개

LIMIT 예제 <br>
LIMIT n		=> 상위 n개 조회 <br>
LIMIT n, m  => n+1행부터 m개 조회.

~~~SQL
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
~~~