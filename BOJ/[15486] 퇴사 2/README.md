퇴사 2
===

문제 링크 : https://www.acmicpc.net/problem/15486

<hr>

### 풀이

DP로 해결해야되는 문제다.

DP 중에서도 반복적 동적 계획법을 사용해야 되는 것 같다.

재귀 함수로 문제를 물었을 땐 (문제의 범위 때문인지) 시간초과가 나온다.

문제의 알고리즘은 다음과 같다.

~~~java
static int getMaxIncome(int N, int[] T, int[] P) {
	int[] dp = new int[N + 2];

	for (int i = N; i >= 1; i--) {
		if (i + T[i] > N + 1)		//날짜를 넘어가면 이전에 있는 최대값을 사용.
			dp[i] = dp[i + 1];
		else						//날짜를 넘어가지 않는다면 
			dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
	}
	return dp[1];
}
~~~

