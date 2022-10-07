동명 동물 수 찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59041

<br>

### 풀이

동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 죄회. 이때 결과는 이름이 없는 동물은 집계 제외. 결과는 이름 순

두 번 이상 쓰인 이름 => GROUP BY NAME 으로 묶고, COUNT 사용. <br>
이름이 없는 동물 => COUNT에서 NULL은 제외됨. <br>
결과는 이름 순 => ORDER BY NAME <br>

~~~SQL
SELECT NAME, COUNT(*)
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME;
~~~