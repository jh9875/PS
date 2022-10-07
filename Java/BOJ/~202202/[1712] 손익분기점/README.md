손익분기점
===

문제 링크 : https://www.acmicpc.net/problem/1712

<br>

### 풀이

단순하게 생각하면 반복문으로 계산할 수 있지만, 예제 입력3을 보면 무조건 시간초과가 나올거라 생각이 들었다. </br>
이런 유형의 문제는 (단순하게 생각해서 덧셈 뺄셈을 많이하는 문제) 나누기로 빠르게 해결 가능할거라 생각했다.

일단 문제의 손익분기점을 계산해보면 고정비용(A)이 있고, 거기서 가변비용(B)과 가격을 이용한다. </br>
여기서 물건을 여러대 생산할 때 고정비용은 그대로고, 가변 비용과 가격에 의해서 결정된다.

> 고정비용 < (가격 - 가변비용) * n

위 식을 만족하는 n을 구하면 된다.

다만 가격보다 가변비용이 비싸면 손익분기점이 존재하지 않으므로 -1을 반환하도록 한다.

위 원리를 코드로 나타내보면 아래와 같이 표현할 수 있다.

~~~java
private static int getBreakEvenPoint(int fixedCost, int variableCost, int price) {
	if (variableCost >= price)
		return -1;
	int diff = price - variableCost;
	
	return (fixedCost / diff) + 1;
}
~~~



