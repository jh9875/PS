import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	//stack »ç¿ë.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> left, right;
		String input;
		int T, inputLen;

		T =Integer.parseInt(br.readLine());
		while(T-->0) {
			input =br.readLine();
			inputLen =input.length();	
			left =new Stack<>();
			right =new Stack<>();
			
			for(int i =0; i <inputLen; ++i) {
				char ch =input.charAt(i);

				if(ch =='<') {
					if(!left.isEmpty()) right.add(left.pop());
				}else if(ch =='>') {
					if(!right.isEmpty()) left.add(right.pop());
				}else if(ch =='-') {
					if(!left.isEmpty()) left.pop(); 
				}else {
					left.add(ch);
				}
			}
			while(!left.isEmpty())
				right.add(left.pop());
			while(!right.isEmpty())
				bw.write(right.pop() +"");
			bw.write("\n");
		}
		bw.flush();
	}
}
