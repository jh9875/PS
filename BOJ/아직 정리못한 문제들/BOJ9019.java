import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pair {
		int num;
		String commands;
		Pair(int num, String commands) {
			this.num =num;
			this.commands =commands;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			st =new StringTokenizer(br.readLine());
			int A =Integer.parseInt(st.nextToken());
			int B =Integer.parseInt(st.nextToken());
			bw.write(bfs(A, B) +"\n");
		}
		bw.flush();
	}

	static String bfs(int A, int B) {
		Queue<Pair> queue =new LinkedList<>();
		boolean[] visited =new boolean[10000];		//hashset으로 대체 가능?

		queue.add(new Pair(A, new String()));
		visited[A] =true;
		
		while(!queue.isEmpty()) {
			int num =queue.peek().num;
			String commands =queue.peek().commands;
			queue.poll();

			if(num ==B) return commands.toString();

			int newNum =0;
			//D
			newNum =(num*2) %10000;
			if(!visited[newNum]) {
				queue.add(new Pair(newNum, commands +"D"));
				visited[newNum] =true;
			}
			//S
			newNum =num-1 <0? 9999: num-1;
			if(!visited[newNum]) {
				queue.add(new Pair(newNum, commands +"S"));
				visited[newNum] =true;
			}
			//L
			newNum =((num%1000) *10) +(num/1000);
			if(!visited[newNum]) {
				queue.add(new Pair(newNum, commands +"L"));
				visited[newNum] =true;
			}
			//R
			newNum =((num%10) *1000) +(num/10);
			if(!visited[newNum]) {
				queue.add(new Pair(newNum, commands +"R"));
				visited[newNum] =true;
			}
		}

		return "";
	}
}
