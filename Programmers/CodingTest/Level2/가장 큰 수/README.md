가장 큰 수
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746

<br>

### 풀이

문제의 분류에도 나와있듯이 정렬해서 푸는 문제다.

다만 문자열을 역정렬 하면 예제에서부터 걸린다.

문제의 예제에서 numbers = {3, 30, 34, 5, 9} 일때 역정렬하면 9534303이 나온다.

정답인 9534330이랑 다르다. 틀린 이유는 3과 30을 정렬할 때 역정렬 하면 30, 3 순서로 되는데 문제를 풀려면 3, 30이 나와야 한다.

결국 새로운 정렬 기준을 정해야 한다. 자바에서는 Comparable과 Comparator를 사용했는데 다음과 같이 간단하게 할 수 있다.

~~~java
Collections.sort(strNumberList, new Comparator<String>() {
	@Override
	public int compare(String s1, String s2) {
		return (s2 + s1).compareTo(s1 + s2);
	}
});
~~~