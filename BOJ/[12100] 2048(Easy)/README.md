2048 (Easy)
===

문제 링크 : https://www.acmicpc.net/problem/12100

<br>

### 풀이

최대 5번 움직일 수 있으므로 모든 경우를 탐색해보고 가장 큰 수가 나오는 경우를 출력하면 된다.

구현이 까다롭지만, 하나씩 천천히 구현하면 되는 것 같다.

~~~java
static int simulateMoveBlock(int N, int[][] board, int numOfMove) {
	if (numOfMove > 5)
		return 0;
	int ret = maxValueOfBoard(N, board);

	for (int dir = 0; dir < 4; dir++) {
		int[][] movedBoard = getMovedBoard(N, board, dir);
		ret = Math.max(ret, simulateMoveBlock(N, movedBoard, numOfMove + 1));
	}
	return ret;
}
~~~

첫 번째로 모든 경우를 따져보는 함수다. <br>
기저 사례로 5번이 넘어가면 0을 반환해서 무시한다. <br>
방향별로 움직인 board를 저장하고 넘겨준다.

~~~java
static int simulateMoveBlock(int N, int[][] board, int numOfMove) {
	if (numOfMove > 5)
		return 0;
	int ret = maxValueOfBoard(N, board);

	for (int dir = 0; dir < 4; dir++) {
		int[][] movedBoard = getMovedBoard(N, board, dir);
		ret = Math.max(ret, simulateMoveBlock(N, movedBoard, numOfMove + 1));
	}
	return ret;
}

static int[][] getMovedBoard(int N, int[][] board, int dir) {
	int[][] movedBoard = getCopyBoard(N, board);
	boolean[][] changed = new boolean[N][N];

	switch (dir) {
	case 0: // south
		for (int x = 0; x < N; x++) {
			for (int y = N - 1; y >= 0; y--) {
				if (board[y][x] != 0)
					moveNumber(y, x, N, movedBoard, dir, changed);
			}
		}
		break;
	case 1: // east
		..
	case 2: // north
		..
	case 3: // west
		..
	}
	return movedBoard;
}
~~~

다음으로 방향에 따라서 숫자 블록을 움직여준다. <br>
여기서 주의해야 할 사항은 움직일 방향에서부터 숫자 블록을 움직여줘야 한다. <br>
왜냐하면 블록은 한 번만 합쳐질 수 있기 때문이다.

~~~java
static void moveNumber(int y, int x, int N, int[][] board, int dir, boolean[][] changed) {
	int value = board[y][x];
	board[y][x] = 0;

	while (true) {
		int nextY = y + dirY[dir];
		int nextX = x + dirX[dir];

		if (inRange(nextY, nextX, N)) {
			if (board[nextY][nextX] != 0) {
				if (!changed[nextY][nextX]) {
					if (value == board[nextY][nextX]) {
						board[nextY][nextX] *= 2;
						changed[nextY][nextX] = true;
					} else { // 숫자가 다른 경우.
						board[y][x] = value;
					}
				} else { // 이미 바뀐경우
					board[y][x] = value;
				}
				break;
			}
		} else { // 보드의 범위를 벗어남.
			board[y][x] = value;
			break;
		}
		y = nextY;
		x = nextX;
	}
}
~~~

다음으로 숫자를 움직이는 함수다. <br>
방향으로 숫자를 움직이며 경우마다 if 문으로 처리해줬다. <br>
처리해줘야 하는 조건들은 다음과 같다.
- board의 범위 안에 들어야 한다.
- board에서 빈칸인지 아닌지 확인해야 한다.
- 빈칸이 아니라면 이미 바뀐 블록인지 아닌지 확인.
- 충돌한 블럭 둘의 숫자가 같은지 아닌지 확인.

위 경우에 따라 잘 처리해주면 된다.