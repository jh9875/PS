평범한 배낭
===

문제 링크 : https://www.acmicpc.net/problem/12865

<br>

### 풀이

모든 경우를 탐색해보고 중복되는 문제를 메모이제이션으로 해결.

문제를 해결하기 위해 다음과 같은 함수를 사용했다.

~~~java
private static int pickStuff(int index, int totalWeight, int numOfStuff, int limitWeight, Stuff[] stuff) {
	if (index >= numOfStuff)
		return 0;
	if (cache[index][totalWeight] != -1)
		return cache[index][totalWeight];
	int ret = pickStuff(index + 1, totalWeight, numOfStuff, limitWeight, stuff);
	if (totalWeight + stuff[index].weight <= limitWeight)
		ret = Math.max(ret, pickStuff(index + 1, totalWeight + stuff[index].weight, numOfStuff, limitWeight, stuff)
				+ stuff[index].value);
	return cache[index][totalWeight] = ret;
}
~~~

물건들의 순서마다 물건을 선택할 경우와 선택하지 않을 경우 중 더 큰 가치를 담을 수 있는 경우를 고르게된다.