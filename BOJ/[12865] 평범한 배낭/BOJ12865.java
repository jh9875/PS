import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Stuff {
		int weight;
		int value;

		Stuff(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	static int[][] cache;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stuff[] stuff;
		int numOfStuff, limitWeight;

		st = new StringTokenizer(br.readLine());
		numOfStuff = Integer.parseInt(st.nextToken());
		limitWeight = Integer.parseInt(st.nextToken());
		stuff = new Stuff[numOfStuff];
		cache = new int[numOfStuff][100001];
		for (int i = 0; i < numOfStuff; i++)
			Arrays.fill(cache[i], -1);
		for (int i = 0; i < numOfStuff; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			stuff[i] = new Stuff(weight, value);
		}
		bw.write(getMaxStuffValue(numOfStuff, limitWeight, stuff) + "\n");
		bw.flush();
	}

	private static int getMaxStuffValue(int numOfStuff, int limitWeight, Stuff[] stuff) {
		return pickStuff(0, 0, numOfStuff, limitWeight, stuff);
	}

	private static int pickStuff(int index, int totalWeight, int numOfStuff, int limitWeight, Stuff[] stuff) {
		if (index >= numOfStuff)
			return 0;
		if (cache[index][totalWeight] != -1)
			return cache[index][totalWeight];
		int ret = pickStuff(index + 1, totalWeight, numOfStuff, limitWeight, stuff);
		if (totalWeight + stuff[index].weight <= limitWeight)
			ret = Math.max(ret, pickStuff(index + 1, totalWeight + stuff[index].weight, numOfStuff, limitWeight, stuff)
					+ stuff[index].value);
		return cache[index][totalWeight] = ret;
	}

}