유아와 곰두리차
===

문제 링크 : https://www.acmicpc.net/problem/20951

<br>

### 풀이

dp로 해결 가능한 문제.

길이가 7인 경로를 탐색해야 하고, 정점 또는 간선을 재방문하는 것이 허용된다.

그것을 구현해서 아래와같이 만들어봤다.

~~~java
static int moveNextVertex(int nowVertexNum, int count) {
	if (count == 7)
		return 1;
	if (cache[nowVertexNum][count] != -1)
		return cache[nowVertexNum][count];
	int ret = 0;

	for (int nextvertexNum : graph[nowVertexNum])
		ret = (ret + moveNextVertex(nextvertexNum, count + 1)) % MOD;

	return cache[nowVertexNum][count] = ret % MOD;
}
~~~

중복으로 계산되는 것을 방지하기 위해 메모이제이션을 이용했다.

cache가 의미하는 것은 다음과 같다.

- cache[정점의 번호][방문한 정점의 수]

기저 사례로 길이가 7이 됐을 때, 1을 반환한다. (한가지 경우로 셈)

반복적 DP로 풀 때 다음과 같은 점화실을 세울 수 있다.

- dp[count][vertexNum] = 길이가 count 이면서 정점 vertexNum으로 끝나는 경로의 개수

- dp[count][adjVertexNum] = (dp[count][adjVertexNum] + dp[count - 1][vertexNum]) % MOD;