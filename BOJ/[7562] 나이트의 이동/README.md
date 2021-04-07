나이트의 이동
===

문제 링크 : https://www.acmicpc.net/problem/7562

<br>

### 풀이

bfs로 탐색하는 문제.

현재 나이트의 위치가 nowY, nowX라고 했을 때,
~~~java
for (int d = 0; d < 8; d++) {
	int nextY = nowY + dirY[d];
	int nextX = nowX + dirX[d];
	if (!inRange(nextY, nextX, length) || visited[nextY][nextX])
		continue;
	visited[nextY][nextX] = true;
	queue.add(new Pos(nextY, nextX, count + 1));
}
~~~

이때 나이트의 이동 폭은
~~~java
static int[] dirY = { -1, -2, -2, -1, 1, 2, 2, 1 };
static int[] dirX = { -2, -1, 1, 2, 2, 1, -1, -2 };
~~~