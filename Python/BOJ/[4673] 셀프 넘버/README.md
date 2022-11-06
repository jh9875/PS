셀프 넘버
===

문제 링크 : https://www.acmicpc.net/problem/4673

<br>

### 풀이

처음엔 그냥 생각나는대로 풀어봤다.

1부터 10000까지의 모든 수를 갖고있는 list가 있고, for 문으로 돌면서 d(n)을 이용해서 생성자가 있는 수를 list의

remove() 함수를 통해 없어주는 방식으로 해봤다. 결과는 정답이었다.

하지만 시간이 꽤나 걸렸다.

그래서 시간이 적게 나온 다른 사람들의 코드를 봤다.

그러다 Python에 있는 특이한 기능을 발견했다.

알고보니 파이썬에선 set 에서 집합과 관련된 연산을 지원한다.

만약 a와 b라는 set이 존재한다고 한다면.

- 교집합 <br>
  a & b 또는 a.intersection(b)
- 합집합 <br>
  a | b 또는 a.union(b)
- 차집합 <br>
  a - b 또는 a.difference(b)

참고 : https://velog.io/@insutance/Python-set-이란

아무튼 파이썬엔 유용한 기능들이 많아서 좋은 것 같다.