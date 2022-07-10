문자열 반복
===

문제 링크 : https://www.acmicpc.net/problem/2675

<hr>

### 풀이

각 테스트케이스마다 반복된 문자열을 출력하면 됨.

각 문자를 R번 반복하기위해 char 배열로 만든 다음 반복문을 이용해 반복된 문자열을 만듬.

~~~java
static String getRepeatedStr(int R, String s) {
	StringBuilder sb = new StringBuilder();
	char[] charArr = s.toCharArray();

	for (char ch : charArr) {
		for (int i = 0; i < R; i++)
			sb.append(ch);
	}
	return sb.toString();
}
~~~

