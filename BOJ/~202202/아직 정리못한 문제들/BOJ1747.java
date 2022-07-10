import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static final int MAX =Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;

		N =Integer.parseInt(br.readLine());
		while(N <MAX) {
			if(isPrime(N) && isPalindrome(N)) {
				bw.write(N +"\n");
				break;
			}
			++N;
		}
		bw.flush();
	}

	static boolean isPrime(int num) {
		if (num == 1)
			return false;
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}

	static boolean isPalindrome(int num) {
		String strNum =String.valueOf(num);
		int len =strNum.length();
		int halfLen =len/2;

		for(int i =0; i <halfLen; ++i) {
			if(strNum.charAt(i) !=strNum.charAt(len-i-1))
				return false;
		}
		return true;
	}
}
