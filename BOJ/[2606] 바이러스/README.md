바이러스
===

문제 링크 : https://www.acmicpc.net/problem/2606

<br>

### 풀이

1번 컴퓨터를 시작으로 BFS를 탐색해서 연결되어 있는 컴퓨터의 수를 반환하면 된다.

이중 boolean 배열로 연결을 체크했고, boolean 배열로 감염된 컴퓨터를 체크했다.

그리고 queue를 이용해서 1을 시작하는 BFS를 하면 해결.