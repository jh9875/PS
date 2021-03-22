import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	//방법 2 Stack 2개 사용.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Character> left, right;
		String str;
		int N, strLen;

		str =br.readLine();
		strLen =str.length();
		left =new Stack<>();
		right =new Stack<>();
		for(int i =0; i <strLen; ++i)
			left.add(str.charAt(i));

		N =Integer.parseInt(br.readLine());
		while(N-->0) {
			st =new StringTokenizer(br.readLine());
			char command =st.nextToken().charAt(0);

			if(command =='L') {
				if(!left.isEmpty()) right.add(left.pop());
			}else if(command =='D') {
				if(!right.isEmpty()) left.add(right.pop());
			}else if(command =='B') {
				if(!left.isEmpty()) left.pop();
			}else if(command =='P') {
				left.add(st.nextToken().charAt(0));
			}
		}

		while(!left.isEmpty())
			right.add(left.pop());
		while(!right.isEmpty())
			bw.write(right.pop() +"");
		bw.flush();
	}
}
