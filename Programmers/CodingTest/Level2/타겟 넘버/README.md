타겟 넘버
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165

<br>

### 풀이

모든 경우를 탐색하면 해결할 수 있다.

~~~java
public int searchTargetNumber(int index, int sum, int target, int[] numbers) {
	if (index == numbers.length) {
		if (sum == target)
			return 1;
		return 0;
	}
	return searchTargetNumber(index + 1, sum + numbers[index], target, numbers)
			+ searchTargetNumber(index + 1, sum - numbers[index], target, numbers);
}
~~~

numbers에 있는 수를 더하거나 빼야 하므로 2가지 경우만 고려해주면 된다.