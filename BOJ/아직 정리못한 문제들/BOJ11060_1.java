import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Pos implements Comparable<Pos> {
		int index, cnt;

		Pos(int index, int cnt) {
			this.index =index;
			this.cnt =cnt;
		}

		@Override
		public int compareTo(Pos p) {
			return this.cnt-p.cnt;
		}
	}

	static int N;
	static int[] maze;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		maze =new int[N+1];
		st =new StringTokenizer(br.readLine());
		for(int i =1; i <=N; ++i)
			maze[i] =Integer.parseInt(st.nextToken());
		
		bw.write(escape() +"\n");
		bw.flush();
	}

	//우선순위 큐를 사용한 bfs
	static int escape() {
		PriorityQueue<Pos> pq =new PriorityQueue<>();
		boolean[] visited =new boolean[N+1];

		pq.add(new Pos(1, 0));
		visited[1] =true;

		while(!pq.isEmpty()) {
			int index =pq.peek().index;
			int cnt =pq.peek().cnt;
			pq.poll();

			if(index ==N)
				return cnt;
			
			int maximumJump =maze[index];
			for(int i =1; i <=maximumJump; ++i) {
				if(index+i <=N && !visited[index+i]) {
					pq.add(new Pos(index+i, cnt+1));
					visited[index+i] =true;
				}
			}
		}
		return -1;
	}
}
