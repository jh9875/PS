RGB거리
===

문제 링크 : https://www.acmicpc.net/problem/1149

<hr>

### 풀이

DP로 해결하는 문제.

모든 집마다 순서대로 색을 적용해보고 가장 최소가 되도록 하는 값을 출력.

~~~java
static int getMinimumPaintingPayment(int index, int color) {
	if (index == N)
		return 0;
	if (cache[index][color] != -1)
		return cache[index][color];
	int ret = rgbPayments[index][color];

	ret += Math.min(getMinimumPaintingPayment(index + 1, (color + 1) % 3),
			getMinimumPaintingPayment(index + 1, (color + 2) % 3));
	return cache[index][color] = ret;
}
~~~

함수는 집의 순서 index와 해당 색 color를 인자로 받는다.

현재 index집의 색에따라 다음에 올 수 있는 집은 두가지이다.

색은 0~2로 정할 수 있으므로, 현재 색을 color라고 했을 때 나머지 두 색은 (color+1)%3, (color+2)%3이다.