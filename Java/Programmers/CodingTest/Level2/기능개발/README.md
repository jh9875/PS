기능개발
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586

<br>

### 풀이

2가지 방법 정도를 생각해봤다. <br>
- 문제에 나온 그대로 기능을 구현 (progresses[i]에 speeds[i]를 더하면서 100 넘은게 있으면 앞에서 부터 세기)
- 걸리는 시간을 미리 계산해서 순서대로 세기

두 번째 방법으로 풀 때 걸리는 시간은 다음과 같이 계산했다.

~~~java
public int[] getTakeDays(int[] progresses, int[] speeds) {
    int progressesLen = progresses.length;
    int[] takeDays = new int[progressesLen];

    for (int i = 0; i < progressesLen; i++) {
    	int quotient = (100 - progresses[i]) / speeds[i];
    	int remainder = (100 - progresses[i]) % speeds[i];
    	takeDays[i] = remainder == 0 ? quotient : quotient + 1;
    }
    return takeDays;
}
~~~

위와 같이 계산하면 진도가 100%가 될 때 까지 걸리는 날들이 int 형 배열에 저장된다.

그 다음으로 solution 함수는 아래와 같이 만들었다.

~~~java
public int[] solution(int[] progresses, int[] speeds) {
	List<Integer> answer = new ArrayList<>();
	int[] takeDays = getTakeDays(progresses, speeds);
	int progressesLen = progresses.length;
	int index = 0;

	while (index < progressesLen) {
		int nextProgressIndex = index;
		int count = 0;

		while (nextProgressIndex < progressesLen && takeDays[index] >= takeDays[nextProgressIndex]) {
			nextProgressIndex++;
			count++;
		}
		answer.add(count);
		index = nextProgressIndex;
	}

	return answer.stream().mapToInt(i -> i.intValue()).toArray();
}
~~~

배포는 앞에서부터 해야하므로, 앞에 있는 걸리는 날보다 뒤에 있는 걸리는 날이 작으면 그 만큼 count를 세서 answer 리스트에 담는다.