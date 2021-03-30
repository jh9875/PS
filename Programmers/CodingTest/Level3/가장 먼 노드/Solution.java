import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    class Edge implements Comparable<Edge> {
        int here;
        int cost;

        Edge(int here, int cost) {
            this.here = here;
            this.cost = cost;
        }

        @Override
        public int compareTo(Solution.Edge o) {
            return this.cost - o.cost;
        }
    }

    ArrayList<Integer>[] graph;
    int[] dist;

    public int solution(int n, int[][] edge) {
        dist = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        dijkstra(n);
        return numOfMax();
    }

    void dijkstra(int n) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            int here = pq.peek().here;
            int cost = pq.peek().cost;
            pq.poll();

            if (dist[here] < cost)
                continue;

            for (int there : graph[here]) {
                int nextCost = cost + 1;

                if (dist[there] > nextCost) {
                    dist[there] = nextCost;
                    pq.add(new Edge(there, nextCost));
                }
            }
        }
    }

    int numOfMax() {
        int ret = 0;
        int max = IntStream.of(dist).filter(i -> i < Integer.MAX_VALUE).max().orElse(0);

        for (int maxValue : dist)
            if (maxValue == max)
                ret++;
        return ret;
    }
}