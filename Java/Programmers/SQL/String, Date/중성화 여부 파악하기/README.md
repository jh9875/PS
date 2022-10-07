중성화 여부 파악하기
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/59409

<br>

### 풀이

보호소의 동물이 중성화되었는지 아닌지 파악. 중성화된 동물은 SEX_UPON_INTAKE 컬림에 'Neutered' or 'Spayed'로 되어있음. <br>
동물의 아이디와 이름, 증성화 여부를 아이디 순으로 조회. 중성화 되어있다면 'O', 아니면 'X'로 표시

IF와 CASE로 해결 가능. LIKE로 해당 패턴이 있는지 확인후 O, X로 출력.

~~~sql
# IF 활용
SELECT ANIMAL_ID, NAME, IF(SEX_UPON_INTAKE LIKE 'Neutered%' OR SEX_UPON_INTAKE LIKE 'Spayed%', 'O', 'X') AS 중성화
FROM ANIMAL_INS;
~~~

~~~sql
# CASE, WHEN, THEN, ELSE 사용
SELECT ANIMAL_ID, NAME, CASE
                            WHEN SEX_UPON_INTAKE LIKE 'Neutered%' THEN 'O'
                            WHEN SEX_UPON_INTAKE LIKE 'Spayed%' THEN 'O'
                            ELSE 'X'
                        END AS '중성화'
FROM ANIMAL_INS;
~~~