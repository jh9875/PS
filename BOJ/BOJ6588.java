import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static final int MAX =1000000;
	static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;

		eratosthenes(MAX);

		while(true) {
			n =Integer.parseInt(br.readLine());
			if(n ==0) break;

			boolean success =false;

			for(int i =3; i <=n; i +=2) {
				if(isPrime[i] && isPrime[n-i]) {
					bw.write(n +" = " + i + " + " +(n-i) +"\n");
					success =true;
					break;
				}
			}
			if(!success)
				bw.write("Goldbach's conjecture is wrong.");
		}
		bw.flush();
	}

	static void eratosthenes(int max) {
		isPrime = new boolean[max + 1];

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int sqrtn = (int) Math.sqrt(max);

		for (int i = 2; i <= sqrtn; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= max; j += i)
					isPrime[j] = false;
			}
		}
	}
}
