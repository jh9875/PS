등굣길
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42898

<br>

### 풀이

동정 계획법으로 해결.

재귀 함수로 완전 탐색 하면서 이미 탐색한 부분은 cache를 사용하면서 중복계산 방지.

이동 불가한 부분은 기저 사례로 처리.

~~~java
int goToSchool(int y, int x) {
	if ((y == N || x == M) || cantMove[y][x])
		return 0;
	if (y == N - 1 && x == M - 1)
		return 1;
	if (cache[y][x] != -1)
		return cache[y][x];

	return cache[y][x] = goToSchool(y + 1, x) % MOD + goToSchool(y, x + 1) % MOD;
}
~~~