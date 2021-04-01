구명 보트
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42885

<br>

### 풀이

문제에 보면 하나의 보트에 최대 2명 탈 수 있고, 무게 제한이 있다.

사람들의 무게를 정렬한 다음 무거운 사람과 가벼운 사람을 같이 태우면 된다.

단 무게를 초과하는 경우 한사람만 태운다.

~~~java
while (left <= right) {
	int sum = people[left] + people[right];
	if (sum <= limit) { // 두명 타는 경우
		left++;
		right--;
	} else { // 한명만 타는 경우
		right--;
	}
	answer++;
}
~~~