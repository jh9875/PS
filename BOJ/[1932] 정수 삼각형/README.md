정수 삼각형
===

문제 링크 : https://www.acmicpc.net/problem/1932

<br>

### 풀이

동적 계획법으로 해결했다.

```java
ret = Math.max(getMaximumSum(row + 1, col, N, triangle), getMaximumSum(row + 1, col + 1, N, triangle))
				+ triangle[row][col];
```

이러한 식을 사용해서 다음에 올 값이 큰것을 비교하여 결정하도록 했다.