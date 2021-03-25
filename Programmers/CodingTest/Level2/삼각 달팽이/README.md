삼각 달팽이
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/68645

<br>

### 풀이

이차원 int 배열에 문제에 주어진 규칙대로 채운 후, 결과를 따로 반환하는 방식으로 해결했다.

문제에서 수가 채워지는 방향은 아래, 오른쪽, 왼쪽위 대각선이다.

이차원 int 배열에서 현재 수를 채워야하는 위치를 (y, x)라고 할 때, 다음 방향으로는 다음과 같은 수를 더해서 이동할 수 있다.

~~~java
static int[] dirY = { 1, 0, -1 };
static int[] dirX = { 0, 1, -1 };

...

while(triangle[y][x] == 0) {
	int nextY = y + dirY[dir];
	int nextX = x + dirX[dir];
	..
}
~~~

이때 범위를 벗어나거나 이미 채워진 위치이면 방향을 틀어야 한다.

~~~java
if (!inRange(nextY, nextX, n) || (inRange(nextY, nextX, n) && triangle[nextY][nextX] != 0)) {
	dir = (dir + 1) % 3;
	nextY = y + dirY[dir];
	nextX = x + dirX[dir];
}
~~~

이런 방식으로 2차원 int 배열을 채울 수 있다.