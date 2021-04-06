import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class KanghoInfo {
		int floor;
		int cnt;
		KanghoInfo(int floor, int cnt) {
			this.floor =floor;
			this.cnt =cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int F, S, G, U, D;

		st =new StringTokenizer(br.readLine());
		F =Integer.parseInt(st.nextToken());
		S =Integer.parseInt(st.nextToken());
		G =Integer.parseInt(st.nextToken());
		U =Integer.parseInt(st.nextToken());
		D =Integer.parseInt(st.nextToken());

		bw.write(bfs(F, S, G, U, D) +"\n");
		bw.flush();
	}

	static String bfs(int F, int S, int G, int U, int D) {
		Queue<KanghoInfo> queue =new LinkedList<>();
		boolean[] visited =new boolean[F+1];

		queue.add(new KanghoInfo(S, 0));
		visited[S] =true;

		while(!queue.isEmpty()) {
			int floor =queue.peek().floor;
			int cnt =queue.peek().cnt;
			queue.poll();

			if(floor ==G)
				return String.valueOf(cnt);
			
			if(floor +U <=F && !visited[floor +U]) {
				queue.add(new KanghoInfo(floor+U, cnt+1));
				visited[floor +U] =true;
			}
			if(floor -D >0 && !visited[floor -D]) {
				queue.add(new KanghoInfo(floor-D, cnt+1));
				visited[floor -D] =true;
			}
		}
		return "use the stairs";
	}
}
