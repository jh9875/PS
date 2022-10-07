가장 먼 노드
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/49189

<br>

### 풀이

다익스트라 알고리즘으로 해결할 수 있다.

1번 노드에서 나머지 노드의 떨어진 거리 배열은 다음과 같이 구했다.

~~~java
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
~~~

그 다음으로 최대 값을 구하고

~~~java
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
~~~

다음으로 최대 값의 개수를 구하면 된다.

~~~java
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
~~~