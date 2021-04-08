import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static class RGB {
		int r, g, b;

		RGB(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	static int N;
	static RGB[] colors;
	static RGB gomduriColor;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		colors = new RGB[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			colors[i] = new RGB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		gomduriColor = new RGB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		bw.write(minumumDiffColor(0, 0, new boolean[N]) + "\n");
		bw.flush();
	}

	static int minumumDiffColor(int index, int numOfPick, boolean[] picked) {
		if (numOfPick > 7)
			return 987654321;
		int ret = 987654321;
		if (numOfPick > 1)
			ret = mixColor(picked);

		for (int i = index; i < N; i++) {
			if (!picked[i]) {
				picked[i] = true;
				ret = Math.min(ret, minumumDiffColor(i + 1, numOfPick + 1, picked));
				picked[i] = false;
			}
		}
		return ret;
	}

	static int mixColor(boolean[] picked) {
		int r = 0, g = 0, b = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (picked[i]) {
				r += colors[i].r;
				g += colors[i].g;
				b += colors[i].b;
				count++;
			}
		}
		r /= count;
		g /= count;
		b /= count;
		return Math.abs(gomduriColor.r - r) + Math.abs(gomduriColor.g - g) + Math.abs(gomduriColor.b - b);
	}
}
