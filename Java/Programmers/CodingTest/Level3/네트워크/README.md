네트워크
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162

<br>

### 풀이

DFS/BFS로 해결할 수 있는 간단한 문제다.

~~~java
public void dfs(int now, int n, int[][] computers) {
	visited[now] = true;

	for(int next =0; next <n; next++) {
		if(computers[now][next] == 1 && !visited[next]) {
			dfs(next, n, computers);
		}
	}
}
~~~

~~~java
public void bfs(int start, int n, int[][] computers) {
	Queue<Integer> queue = new LinkedList<>();

	queue.add(start);
	visited[start] = true;

	while (!queue.isEmpty()) {
		int now = queue.poll();

		for (int next = 0; next < n; next++) {
			if (computers[now][next] == 1 && !visited[next]) {
				queue.add(next);
				visited[next] = true;
			}
		}
	}
}
~~~