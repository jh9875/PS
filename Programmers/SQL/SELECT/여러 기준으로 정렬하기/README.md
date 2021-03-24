여러 기준으로 정렬하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59404

<br>

### 풀이

모든 동물의 아이디와 이름, 보호 시작일을 이름순으로 조회. 이름이 같은 동물은 보호를 나중에 시작한 동물을 먼저.

모든 동물의 => WHERE 조건 없음 <br>
아이디와 이름, 보호 시작일 => SELECT ANIMAL_ID, NAME, DATETIME <br>
이름순으로 => ORDER BY NAME (ASC) <br>
이름이 같은 동물은 보호를 나중에 시작한 동물을 먼저 => DATETIME DESC <br>

정렬 기준이 여러가지라면 우선 순위가 높은거부터 먼저 쓰고 다음 조건을 나열.

~~~SQL
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC;
~~~