팰린드롬인지 확인하기
===

문제 링크 : https://www.acmicpc.net/problem/10988

<hr>

### 풀이

팰린드롬인지 확인하려면 문자열의 i번째와 length-1-i번째가 같은지 확인하면 된다.

처음부터 끝까지 확인할 필요 없이 문자열의 반까지만 확인하면 된다.

~~~java
private static boolean isPalindrome(String str) {
	int strLen = str.length();
	int halfStrLen = strLen / 2;

	for (int i = 0; i < halfStrLen; i++) {
		if (str.charAt(i) != str.charAt(strLen - 1 - i))
			return false;
	}
	return true;
}
~~~

