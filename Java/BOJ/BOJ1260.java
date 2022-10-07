import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        final int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        final int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        boolean[][] graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }

        List<Integer> dfsResult = this.getDfsResult(N, V, graph, new boolean[N + 1]);
        List<Integer> bfsResult = this.getBfsResult(N, V, graph);

        System.out.println(this.printList(dfsResult));
        System.out.println(this.printList(bfsResult));

        br.close();
    }

    private List<Integer> getBfsResult(int N, int V, boolean[][] graph) {
        List<Integer> result = new ArrayList<>(N);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];

        isVisited[V] = true;
        queue.add(V);
        result.add(V);

        while (!queue.isEmpty()) {
            int curVertex = queue.poll();

            for (int linkedVertex = 1; linkedVertex <= N; linkedVertex++) {
                if (graph[curVertex][linkedVertex] && !isVisited[linkedVertex]) {
                    isVisited[linkedVertex] = true;
                    queue.add(linkedVertex);
                    result.add(linkedVertex);
                }
            }
        }

        return result;
    }

    private List<Integer> getDfsResult(int N, int curVertex, boolean[][] graph, boolean[] isVisited) {
        List<Integer> result = new ArrayList<>(N);

        result.add(curVertex);
        isVisited[curVertex] = true;

        for (int linkedVertex = 1; linkedVertex <= N; linkedVertex++) {
            if (graph[curVertex][linkedVertex] && !isVisited[linkedVertex]) {
                result.addAll(this.getDfsResult(N, linkedVertex, graph, isVisited));
            }
        }

        return result;
    }

    private String printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (Integer n : list) {
            sb.append(n).append(" ");
        }

        if (!list.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            new Main().solution();
        } catch (Exception e) {
            System.out.println("solution exception");
        }
    }
}

