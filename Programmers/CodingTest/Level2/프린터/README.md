프린터
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587

<br>

### 풀이

Queue를 이용해 문제 내용 그대로 구현하면 되는 문제다.

원하는 location을 간편하게 찾기 위해 다음과 같은 자료구조를 만들어 사용했다.

~~~java
class Document {
	int index;
	int priority;

	Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}
~~~

~~~java
while (!documentQueue.isEmpty()) {
	Document nowDocument = documentQueue.peek();
	int maxPriority = maxValueInQueue(documentQueue);

	if (nowDocument.priority == maxPriority) {
		documentQueue.poll();
		answer++;
		if (nowDocument.index == location)
			break;
	} else {
		documentQueue.add(documentQueue.poll());
	}
}
~~~

while루프를 돌리면서 현재 문서가 가장 중요도가 높은 문서이면 queue에서 빼고, 아니면 다시 넣는다.

그러다 원하는 문서(location)이면 루프를 종료시킨다.