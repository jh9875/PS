입양 시각 구하기(1)
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59412

<br>

### 풀이

보호소에서 몇 시에 입양이 가장 활발하게 일어나는지. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회. 결과는 시간대 순으로 정렬.

시간대별로 조회 => GROUP BY HOUR(DATETIME)으로. (HOUR()는 MySQL에서 제공하는 날짜 관련 함수 중 하나) <br>
09:00부터 19:59까지 => HAVING으로 HOUR >=9 AND HOUR <20으로 범위를 제한. <br>
결과는 시간순 => ORDER BY HOUR

~~~SQL
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR >=9 AND HOUR <20
ORDER BY HOUR;
~~~