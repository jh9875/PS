import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int index, weight;
		Edge(int index, int weight) {
			this.index =index;
			this.weight =weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight -e.weight;
		}
	}

	static int V;
	static List<Edge>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int E, start;

		st =new StringTokenizer(br.readLine());
		V =Integer.parseInt(st.nextToken());
		E =Integer.parseInt(st.nextToken());
		graph =new ArrayList[V+1];
		for(int i =1; i <=V; ++i)
			graph[i] =new ArrayList<>();
		
		start =Integer.parseInt(br.readLine());

		while(E-->0) {
			st =new StringTokenizer(br.readLine());
			int u =Integer.parseInt(st.nextToken());
			int v =Integer.parseInt(st.nextToken());
			int w =Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
		}

		int[] answer =dijkstra(start);
		for(int i =1; i <=V; ++i)
			bw.write(answer[i] ==Integer.MAX_VALUE? "INF\n": answer[i] +"\n");
		bw.flush();
	}

	static int[] dijkstra(int start) {
		PriorityQueue<Edge> pq =new PriorityQueue<>();
		int[] dist =new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] =0;
		pq.add(new Edge(start, 0));

		while(!pq.isEmpty()) {
			int curIndex =pq.peek().index;
			int weight =pq.peek().weight;
			pq.poll();

			if(dist[curIndex] <weight) continue;

			for(Edge e : graph[curIndex])  {
				int nextIndex =e.index;
				int nextWeight =e.weight;

				if(dist[nextIndex] >weight +nextWeight) {
					dist[nextIndex] =weight +nextWeight;
					pq.add(new Edge(nextIndex, weight+nextWeight));
				}
			}
		}

		return dist;
	}
}