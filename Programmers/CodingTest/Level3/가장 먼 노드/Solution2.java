import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	class Edge implements Comparable<Edge> {
		int index;
		int cost;

		Edge(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

	public int solution(int n, int[][] edge) {
		int[] distance = getDistanceArr(n, edge);
		int maxValue = getMaxValue(n, distance);
		return getNumOfMax(maxValue, n, distance);
	}

	public int[] getDistanceArr(int n, int[][] edge) {
		int[] distance = new int[n + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.add(new Edge(1, 0));
		distance[1] = 0;

		while (!pq.isEmpty()) {
			int now = pq.peek().index;
			int cost = pq.peek().cost;
			pq.poll();

			if (cost > distance[now])
				continue;

			for (int[] someEdge : edge) {
				int v1 = someEdge[0];
				int v2 = someEdge[1];
				int next = 0;

				if (now == v1) {
					next = v2;
				} else if (now == v2) {
					next = v1;
				} else
					continue;
				if (distance[next] > cost + 1) {
					pq.add(new Edge(next, cost + 1));
					distance[next] = cost + 1;
				}
			}
		}

		return distance;
	}

	// 무한대가 아닌 최대 값
	public int getMaxValue(int n, int[] distance) {
		int index = n - 1;
		Arrays.sort(distance);

		while (index >= 0) {
			if (distance[index] != Integer.MAX_VALUE)
				return distance[index];
			index--;
		}

		return 0;
	}

	// 최대값의 개수
	public int getNumOfMax(int max, int n, int[] distance) {
		int count = 0;
		int index = n - 1;

		Arrays.sort(distance);

		while (index >= 0) {
			int num = distance[index--];
			if (num == Integer.MAX_VALUE)
				continue;
			if (num == max)
				count++;
			else
				break;
		}

		return count;
	}
}