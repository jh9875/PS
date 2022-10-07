입양 시각 구하기(2)
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59413

<br>

### 풀이

보호소에서 몇 시에 입양이 가장 활발하게 일어나는지. 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생하는지 조회. 결과는 시간순.

입양 시각 구하기(1)처럼 GROUP BY로 해결하려 했더니 HOUR의 수가 0인 것을 세지 못함. => 변수로 해결 가능.

hour라는 변수를 0~23까지 증가시키면서 HOUR(DATETIME)인 것을 count하면 됨.

~~~SQL
SET @hour :=-1;

SELECT (@hour :=@hour+1) AS HOUR,
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE @hour = HOUR(DATETIME)) AS COUNT
FROM ANIMAL_OUTS
WHERE @hour <23;
~~~
