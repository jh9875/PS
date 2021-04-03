문자열 다루기 기본
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/12918

<br>

### 풀이

길이가 4 또는 6

~~~java
public boolean isLength4Or6(String input) {
	if (input.length() == 4 || input.length() == 6)
		return true;
	return false;
}
~~~

숫자만 포함 => 정규표현식 사용.

~~~java
public boolean isContainsOnlyNumber(String input) {
	String regex = "^[0-9]+$";
	return Pattern.matches(regex, input);
}
~~~