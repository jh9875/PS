import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		int[] K;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			K[i] = Integer.parseInt(st.nextToken());

		bw.write(sumOfMultiples(N, M, K) + "");
		bw.flush();
	}

	static int sumOfMultiples(int N, int M, int[] K) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < M; i++)
			for (int j = 1; K[i] * j <= N; j++)
				hs.add(K[i] * j);
		return sumOfSet(hs);
	}

	static int sumOfSet(HashSet<Integer> hs) {
		int sum = 0;
		Iterator<Integer> it = hs.iterator();
		while (it.hasNext())
			sum += it.next();
		return sum;
	}
}