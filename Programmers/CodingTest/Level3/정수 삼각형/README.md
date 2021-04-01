정수 삼각형
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43105

<br>

### 풀이

int[][] 배열을 탐색하면서 길이가 거쳐간 숫자의 합이 가장 큰 경우를 계산.

문제의 예시는 다음과 같이 삼각형이 있음.

7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

현재 위치가 (y, x)라고 할 때 다음 위치는 (y+1, x) 또는 (y+1, x+1)이 됨.

~~~java
public int search(int y, int x, int[][] triangle) {
	if (y == triangle.length)
		return 0;
	if (cache[y][x] != -1)
		return cache[y][x];

	return cache[y][x] = triangle[y][x] + Math.max(search(y + 1, x, triangle), search(y + 1, x + 1, triangle));
}
~~~

왼쪽 아래랑 오른쪽 아래 중 더 큰 경로가 되는 값을 반환하면 됨.

중복 계산은 cache를 사용하여 피함.