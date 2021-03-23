2 x n 타일링
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/12900

<br>

### 풀이

DP로 해결할 수 있는 문제다.

재귀 함수로 완전 탐색을 하면서 중복 계산되는 것을 메모이제이션으로 해결해 주었다.

~~~java
public int tiling2(int restWidth) {
	if (restWidth == 0)
		return 1;
	if (cache[restWidth] != -1)
		return cache[restWidth];
	int ret = 0;

	ret += tiling2(restWidth - 1) % MOD;
	if (restWidth - 2 >= 0)
		ret += tiling2(restWidth - 2) % MOD;

	return cache[restWidth] = ret % MOD;
}
~~~

함수의 인자로 채워야 하는 남은 너비를 넣어준다.

한 칸을 채울 땐 한 개의 2x1 크기의 직사각형이 필요하고, <br>
두 칸을 채울 땐 두 개의 1x2 크기의 직사각형이 필요하다.

restWidth ==0 (기저 사례)인 경우 모두 채운 경우의 수 중 한 개이므로 1을 반환한다.