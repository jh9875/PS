고양이와 개는 몇 마리 있을까
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59040

<br>

### 풀이

동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회. 고양이를 개보다 먼저 조회.

문제에 ANIMAL_INT 테이블은 ANIMAL_TYPE이 CAT과 DOG밖에 없어서 따로 지정해주지 않아도 된다.

GROUP BY로 ANIMAL_TYPE만 지정해 주면 된다. 고양이를 먼저 조회해야하므로 ORDER BY ANIMAL_TYPE으로.

~~~SQL
SELECT ANIMAL_TYPE, COUNT(ANIMAL_ID)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;
~~~