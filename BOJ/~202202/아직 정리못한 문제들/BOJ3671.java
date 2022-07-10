import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	static boolean[] isPrime;
	static boolean[] used;
	static int N;
	static int[] pieceOfPaper;
	static HashSet<Integer> hs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		eratosthenes();
		
		int c =Integer.parseInt(br.readLine());
		while(c-->0) {
			String input =br.readLine();
			N =input.length();
			pieceOfPaper =new int[N];
			used =new boolean[N];
			hs =new HashSet<>();
			
			for(int i =0; i <N; ++i)
				pieceOfPaper[i] =input.charAt(i) -'0';
			
			bw.write(solve() +"\n");
		}
		bw.flush();
	}

	static int solve() {
		int ret =0;

		for(int i =0; i <N; ++i) {
			used[i] =true;
			ret +=reconstruct(0, pieceOfPaper[i]);
			used[i] =false;
		}
 
		return ret;
	}

	static int reconstruct(int cnt, int num) {
		if(cnt ==N) return 0;
		int ret =0;

		if(isPrime[num] && !hs.contains(num))  {
			++ret;
			hs.add(num);
		}
		for(int i =0; i <N; ++i) {
			if(!used[i]) {
				used[i] =true;
				ret +=reconstruct(cnt+1, num*10 +pieceOfPaper[i]);
				used[i] =false;
			}
		}

		return ret;
	}

	static void eratosthenes() {
		isPrime =new boolean[10000001];

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		int sqrtn = (int) Math.sqrt(10000000);

		for (int i = 2; i <= sqrtn; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 10000000; j += i)
					isPrime[j] = false;
			}
		}
	}
}
