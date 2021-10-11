블랙잭
===

문제 링크 : https://www.acmicpc.net/problem/2798

<br>

### 풀이

완전 탐색으로 해결 가능한 문제다.

재귀함수로 모든 경우의 수를 탐색하는 방법을 써봤다.

~~~java
private static int getBestBlackjackNumber(int index, int count, int sum) {
	if (count == 0) {
		return sum > M ? 0 : sum;
	}
	int ans = 0;
	for (int i = index; i < N; i++) {
		ans = Math.max(ans, getBestBlackjackNumber(i + 1, count - 1, sum + cards[i]));
	}
	return ans;
}
~~~

이런식으로 만들어봤더니 통과했다.

더 좋은 방법이 있나 다른 풀이를 보니 반복문 3개를 이용하는 방법이 있었다.

무조건 3개만 뽑는 것이 규칙이다 보니 가능한 일이었다.

~~~java
private static int getBestBlackjackNumber(int N, int M, int[] cards) {
	int ans = 0;
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			for (int k = j + 1; k < N; k++) {
				int sum = cards[i] + cards[j] + cards[k];
				if (sum <= M) {
					ans = Math.max(ans, sum);
				}
			}
		}
	}
	return ans;
}
~~~

예전에 풀었던 일곱난장이 문제랑 비슷한 느낌이 난다..