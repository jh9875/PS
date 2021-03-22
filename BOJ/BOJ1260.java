import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	static ArrayList<Integer>[] graph;
	static int N, V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		V =Integer.parseInt(st.nextToken());
		graph =new ArrayList[N+1];
		for(int i =0; i <=N; i++)
			graph[i] =new ArrayList<Integer>();
		
		while(M-->0) {
			st =new StringTokenizer(br.readLine());
			int v1 =Integer.parseInt(st.nextToken());
			int v2 =Integer.parseInt(st.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		for(int i =1; i <=N; i++)
			Collections.sort(graph[i]);

		bw.write(dfs() +"\n");	
		bw.write(bfs() +"\n");			
		bw.flush();
	}

	static String dfs() {
		StringBuilder sb =new StringBuilder();
		boolean[] visited =new boolean[N+1];
		visited[V] =true;
		dfs(V, visited, sb);

		return sb.toString();
	}
	static void dfs(int here, boolean[] visited, StringBuilder sb) {
		sb.append(here +" ");
		for(int next : graph[here]) {
			if(!visited[next]) {
				visited[next] =true;
				dfs(next, visited, sb);
			}
		}
	}

	static String bfs() {
		StringBuilder sb =new StringBuilder();
		Queue<Integer> queue =new LinkedList<>();
		boolean[] visited =new boolean[N+1];

		queue.add(V);
		visited[V] =true;

		while(!queue.isEmpty()) {
			int here =queue.poll();
			sb.append(here +" ");

			for(int next : graph[here]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] =true;
				}
			}
		}
		return sb.toString();
	}
}
