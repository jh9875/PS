영화감독 숌
===

문제 링크 : https://www.acmicpc.net/problem/1436

<br>

### 풀이

브루트포스 문제였다.

단순하게 숫자를 증가해가면서 666이 포함되어있는지 확인해보는 방법으로 해결했다.

```java
private static boolean isContains666(int number) {
	String strNumber = number + "";

	if (strNumber.contains("666"))
		return true;
	return false;
}
```

