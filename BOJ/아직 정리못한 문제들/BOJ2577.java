import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A, B, C;
		int[] answer;

		A =Integer.parseInt(br.readLine());
		B =Integer.parseInt(br.readLine());
		C =Integer.parseInt(br.readLine());
		
		answer =getResult(A, B, C);
		for(int n : answer)
			bw.write(n +"\n");
		bw.flush();
	}

	static int[] getResult(int A, int B, int C) {
		int[] numCounter =new int[10];
		int len;
		String result;

		result =String.valueOf(A*B*C);
		len =result.length();

		for(int i =0; i <len; ++i)
			++numCounter[result.charAt(i) -'0'];
		return numCounter;
	}
}