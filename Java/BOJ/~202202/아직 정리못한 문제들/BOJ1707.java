import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int V;
	static List<Integer>[] graph;
	static int[] marks;								//체크하지 않으면0 구분: 1, 2
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K;
		
		K =Integer.parseInt(br.readLine());
		while(K-->0) {
			st =new StringTokenizer(br.readLine());
			V =Integer.parseInt(st.nextToken());
			int E =Integer.parseInt(st.nextToken());

			initGraph();

			for(int i =0; i <E; ++i) {
				st =new StringTokenizer(br.readLine());
				int v1 =Integer.parseInt(st.nextToken());
				int v2 =Integer.parseInt(st.nextToken());

				graph[v1].add(v2);
				graph[v2].add(v1);
			}

			if(solve()) bw.write("YES\n");
			else bw.write("NO\n");
		}
		bw.flush();
	}

	static void initGraph() {
		graph =new ArrayList[V+1];
		for(int i =1; i <=V; ++i) 
			graph[i] =new ArrayList<>();
		marks =new int[V+1];
	}

	static boolean solve() {
		for(int start =1; start <=V; ++start)
			if(marks[start] ==0)								//방문 하지 않은 지점만
				if(!bfs(start)) return false;
		return true;
	}

	//인접한 정점들을 다른 표시 하면서 모순이면 false
	static boolean bfs(int start) {
		Queue<Integer> queue =new LinkedList<>();		

		queue.add(start);
		marks[start] =1;

		while(!queue.isEmpty()) {
			int here =queue.poll();

			for(int adjacentVertex : graph[here]) {
				if(marks[adjacentVertex] !=0) {					//방문한 적이 있을 때
					if(marks[here] ==marks[adjacentVertex])		//같은 표식이면 실패
						return false;
					else
						continue;
				}

				queue.add(adjacentVertex);
				if(marks[here] ==1)
					marks[adjacentVertex] =2;
				else
					marks[adjacentVertex] =1;
			}
		}

		return true;
	}

} 