주식가격
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42584

<br>

### 풀이

이중 for문으로 해결할 수 있다.

바깥쪽 for문을 기준으로 현재 i번째 주식이 i+1번째 부터 몇 초동안 떨어지지 않는지 세면 된다.

~~~java
for (int i = 0; i < total; i++) {
	for (int j = i + 1; j < total; j++) {
		answer[i]++;
		if (prices[i] > prices[j])
			break;
	}
}
~~~