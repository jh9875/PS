보물
===

문제 링크 : https://www.acmicpc.net/problem/1026

<br>

### 풀이

문제에선 A배열만 재배열 할 수 있다고 나온다.

문제의 정답은 A와 B를 서로 다른 정렬 방식 (오름차순, 내림차순)으로 하면 해결할 수 있다.

~~~java
private static int getResult(int N, int[] A, int[] B) {
	int result = 0;
	Arrays.sort(A);
	Arrays.sort(B);
	for (int i = 0; i < N; i++)
		result += A[i] * B[N-i-1];
	return result;
}
~~~