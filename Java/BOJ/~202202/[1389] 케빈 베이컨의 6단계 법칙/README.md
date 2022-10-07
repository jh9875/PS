케빈 베이컨의 6단계 법칙
===

문제 링크 : https://www.acmicpc.net/problem/1389

<br>

### 풀이

모든 정점에서부터 모든 정점까지 최단경로 => <br>
플로이드 와샬 알고리즘을 사용해서 문제를 해결할 수 있다.

~~~java
for (int k = 1; k <= N; k++) {
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			relations[i][j] = Math.min(relations[i][j], relations[i][k] + relations[k][j]);
		}
	}
}
~~~

i에서 j까지 가는데, k를 거쳐 갈때