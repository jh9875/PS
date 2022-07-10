import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int fixedCost = Integer.parseInt(st.nextToken());
		int variableCost = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());

		bw.write(getBreakEvenPoint(fixedCost, variableCost, price) + "\n");
		bw.flush();
	}

	private static int getBreakEvenPoint(int fixedCost, int variableCost, int price) {
		if (variableCost >= price)
			return -1;
		int diff = price - variableCost;
		
		return (fixedCost / diff) + 1;
	}
}
