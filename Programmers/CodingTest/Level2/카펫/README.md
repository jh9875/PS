카펫
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42842

<br>

### 풀이

문제의 규칙이 있다.

brown과 yellow의 합은 카펫의 가로*세로의 값이다.

카펫의 가로 길이를 width라고 하고, 세로 길이를 height라고 할 때 w+h = (brown+4)/2라는 식이 나온다.

그럼 w =(brown+4)/2 - height이다.

한개의 반복문으로 w나 h의 값을 증가시키면서 조건에 맞는 다른 한 개의 값을 찾으면 해결할 수 있다.