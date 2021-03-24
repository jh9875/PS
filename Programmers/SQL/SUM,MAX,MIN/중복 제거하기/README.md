중복 제거하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59408

<br>

### 풀이

동물 보호소에 들어온 이름이 몇 개인지 조회. <br>
이때 이름이 NULL인 경우는 집계하지 않고, 중복이름은 하나로 셈.

집계함수 사용 <br>
- COUNT => (NULL이 아닌) 이름의 수 세기
- DISTINCT => 중복된 결과를 제거

~~~SQL
SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS;
~~~