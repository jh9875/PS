골드바흐의 추측
===

문제 링크 : https://www.acmicpc.net/problem/9020

<br>

### 풀이

빠른 소수 찾기와 간단한 계산 문제다.

단순하게 생각하면 두 수의 합을 이중 for문으로 생각할 수도 있지만 다음과 같이 표현할 수 있다.

~~~java
private static int[] getGoldbachPartition(int n) {
	int[] result = new int[2];
	int num1 = n / 2, num2 = n / 2;
	while (num1 > 0) {
		if(isPrime(num1) && isPrime(num2)) {
			result[0] = num1;
			result[1] = num2;
			break;
		}
		num1--;
		num2 = n-num1;
	}
	return result;
}
~~~

한 개의 수를 num1이라고 하면 나머지 수는 n-num1이 된다.

그리고 두 소수의 차이가 가장 작은 것을 출력해야 하므로, 시작은 n/2 부터 시작하면 된다.

빠른 소수 찾기는 다음과 같은 함수를 이용할 수 있다.

~~~java
private static boolean isPrime(int num) {
	if (num == 1)
		return false;
	for (int i = 2; i * i <= num; i++)
		if (num % i == 0)
			return false;
	return true;
}
~~~

에라토스테네스의 소수 찾기를 이용한 함수다. 다만 문제의 테스트 케이스가 얼마나 될 지 모르기 때문에 다음과 같이 배열에 한번에 저장해 둘 수 있다.

~~~java
private static void eratosthenes() {
	isPrime = new boolean[MAX + 1];
	Arrays.fill(isPrime, true);
	isPrime[0] = false;
	isPrime[1] = false;
	int sqrtn = (int) Math.sqrt(10000);
	for(int i =2; i <=sqrtn; i++) {
		if(isPrime[i]) {
			for(int j = i*i; j <=MAX; j +=i)
				isPrime[j] = false;
		}
	}
}
~~~