피보나치 수
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/12945

<br>

### 풀이

최대 n의 크기가 100000이므로 재귀함수 보단 반복문으로 해결하는게 좋아보인다.

문제의 입력에 대해서 한개의 정답만을 반환하므로 피보나치 수를 저장하는 배열은 길이가 3인 int형 배열이면 충분한 것 같다.

배열 3칸을 나머지 연산을 활용하여 아래와 같이 계산하면 좋다.

~~~java
public int solution(int n) {
	int[] fibonacci = new int[3];
	fibonacci[0] = 0;
	fibonacci[1] = 1;

	for (int i = 2; i <= n; i++)
		fibonacci[i % 3] = fibonacci[(i - 1) % 3] % MOD + fibonacci[(i - 2) % 3] % MOD;

	return fibonacci[n % 3] % MOD;
}
~~~