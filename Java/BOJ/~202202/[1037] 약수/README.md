약수
===

문제 링크 : https://www.acmicpc.net/problem/1037

<br>

### 풀이

문제의 예제를 보고 유추해보았다.

뭔가 약수들 중 가장 작은수와 가장 큰 수를 곱하면 될것같아서 해봤더니 예제는 맞았다.

수가 한개인 경우 제곱을 하면 맞았다.

~~~java
..

if (divisors.length == 1) {
	ans = (int) Math.pow(divisors[0], 2);
} else {
	Arrays.sort(divisors);
	ans = divisors[N - 1] * divisors[0];
}

..
~~~
