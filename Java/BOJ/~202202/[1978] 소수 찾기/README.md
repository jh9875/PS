1978번 소수 찾기
===

### 문제

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

### 입력

첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

### 출력

주어진 수들 중 소수의 개수를 출력한다.

<br>

문제 링크 : https://www.acmicpc.net/problem/1978

<hr>

### 풀이

~~~java
boolean isPrime(int num) {
	if(num ==1) return false;

	for(int i =2; i*i <=num; ++i) {
		if(num %i ==0)
			return false;
	}
	return true;
}
~~~

위와 같은 함수로 각 수를 소수인지 판별할 수 있다.

위 코드에서 핵심은 i*i <=num인 부분이다.

i를 2~(num-1)까지 모두 확인할 필요 없이 i*i <=num까지인 경우나, i <Math.sqrt(num) 까지만 확인해 봐도 된다.

아니면 boolean 배열을 이용해서 미리 계산해 놓은 다음 확인하는 방법도 있다.

