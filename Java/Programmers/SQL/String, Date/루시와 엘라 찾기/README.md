루시와 엘라 찾기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59046

<br>

### 풀이

동물 보호소에 들어온 동물 중 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회.

이름이 ~~ 인 동물 => IN으로 해결 가능 <br>
WHERE NAME IN (..)

~~~sql
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');
~~~