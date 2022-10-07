분해합
===

문제 링크 : https://www.acmicpc.net/problem/2231

<br>

### 풀이

어떤 자연수의 생성자를 구해야 하는 문제이다.

생성자는 여러 수가 나올 수 있는데 그중 가장 작은 생성자를 구하는 문제이므로 작은 수부터 찾는다.<br>
(나의 경우 마땅히 생각나는 것이 없어서 1부터 N까지 탐색해봤다.)

<br>

일단 가장 먼저 생성자가 될 수 있는 후보들을 작은 수부터 N보다 작은수까지 탐색해봤다.
~~~java
private static int findConstructor(int N) {
	int ret = 0;

	for (int cand = 1; cand < N; cand++) {
		if (isConstructor(cand, N)) {
			ret = cand;
			break;
		}
	}

	return ret;
}
~~~
가장 작은 생성자를 찾는 것이므로 찾으면 멈추고 반환한다.

그다음으로 후보가 생성자인지 확인하는 부분이다. <br>
문제에 있는 대로 후보 수와 후보의 각 자릿수를 더해서 찾는 수와 같은지 확인한다.
~~~java
private static boolean isConstructor(int cand, int N) {
	List<Integer> partsOfNumber = getPartsOfNumber(cand);

	int sum = cand;
	for (int partNum : partsOfNumber) {
		sum += partNum;
	}

	return sum == N ? true : false;
}
~~~

다음으로 해줘야 할 것은 각 수의 부분을 찾는 것이다. <br>
처음엔 String을 이용해서 했었는데, 수를 나눠서 하는 것보다 시간이 2배 정도 걸렸다.. <br>
웬만하면 String을 사용하는 걸 피하는 게 좋을 것 같다.

~~~java
private static List<Integer> getPartsOfNumber(int num) {
	List<Integer> result = new ArrayList<>();

	while (num > 0) {
		result.add(num % 10);
		num /= 10;
	}

	return result;
}
~~~