13460번 구슬 탈출2
===

문제 링크 : https://www.acmicpc.net/problem/13460

<hr>

### 풀이

bfs로 해결할 수 있는 문제다.

다만 문제를 풀 때 몇 가지 고려사항이 있다.

- 기울이는 방향에 따라 먼저 이동할 수 있는 구슬 먼저 이동.
- 구슬 겹치지 않게 하기.
- 이동이 중복되는 것을 막기위해 boolean[][][][] 배열 사용하기.
  
문제를 풀 때 사용한 함수는 다음과 같이 있다.
- int bfs(int redY, int redX, int blueY, int blueX) <br>
  두 구슬을 bfs로 최소한의 움직임으로 구슬을 빼낼 수 있는지 갯수를 반환

- boolean redMoveFirst(int redY, int redX, int blueY, int blueX, int dir) <br>
  빨간 구슬이 먼저 이동할지 파란 구슬이 먼저 이동할지 판단

- getMovedBead(int redY, int redX, int blueY, int blueX, int cnt, int dir, boolean redMove) <br>
이동한 구슬의 결과를 반환.

