import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

	static int N, S;
	static int[] seq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		S =Integer.parseInt(st.nextToken());
		seq =new int[N];

		st =new StringTokenizer(br.readLine());
		for(int i =0; i <N; ++i)
			seq[i] =Integer.parseInt(st.nextToken());

		bw.write(pickSubSeq(-1, 0) +"\n");
		bw.flush();
	}	

	static int pickSubSeq(int index, int sum) {
		if(index ==N) return 0;
		int ret =0;

		if(index !=-1 && sum ==S) ++ret;

		for(int i =index +1; i <N; ++i)
			ret +=pickSubSeq(i, sum +seq[i]);

		return ret;
	}

}