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

	static class Edge implements Comparable<Edge> {
		int index, cost;

		Edge(int index, int cost) {
			this.index =index;
			this.cost =cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost -e.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, start, end;
		List<Edge>[] busCosts;

		N =Integer.parseInt(br.readLine());
		busCosts =new ArrayList[N+1];
		
		for(int i =1; i <=N; ++i)
			busCosts[i] =new ArrayList<>();

		M =Integer.parseInt(br.readLine());
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			int departure =Integer.parseInt(st.nextToken());
			int destination =Integer.parseInt(st.nextToken());
			int cost =Integer.parseInt(st.nextToken());
			busCosts[departure].add(new Edge(destination, cost));
		}
		st =new StringTokenizer(br.readLine());
		start =Integer.parseInt(st.nextToken());
		end =Integer.parseInt(st.nextToken());

		int[] result =dijkstra(N, busCosts, start);
		bw.write(result[end] +"\n");
		bw.flush();
	}

	static int[] dijkstra(int N, List<Edge>[] busCosts, int start) {
		PriorityQueue<Edge> pq =new PriorityQueue<>();
		int[] dist =new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] =0;
		pq.add(new Edge(start, 0));

		while(!pq.isEmpty()) {
			int here =pq.peek().index;
			int cost =pq.peek().cost;
			pq.poll();

			if(dist[here] <cost) continue;

			for(Edge e : busCosts[here]) {
				int there =e.index;
				int nextCost =e.cost;

				if(dist[there] >cost +nextCost) {
					dist[there] =cost +nextCost;
					pq.add(new Edge(there, cost +nextCost));
				}
			}
		}

		return dist;
	}
}