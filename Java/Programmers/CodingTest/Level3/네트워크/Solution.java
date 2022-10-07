import java.util.LinkedList;
import java.util.Queue;

class Solution {
	boolean[] visited;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];

		for (int start = 0; start < n; start++) {
			if (!visited[start]) {
				answer++;
				dfs(start, n, computers);
			}
		}
		return answer;
	}

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

	public void dfs(int now, int n, int[][] computers) {
		visited[now] = true;

		for(int next =0; next <n; next++) {
			if(computers[now][next] == 1 && !visited[next]) {
				dfs(next, n, computers);
			}
		}
	}
}