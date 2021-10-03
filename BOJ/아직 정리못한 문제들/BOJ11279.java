import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Integer num = Integer.parseInt(br.readLine());

			if (num > 0) {
				pq.add(num);
			} else if (num == 0) {
				Integer maxNumber = pq.poll();
				if (maxNumber == null) {
					bw.write("0\n");
				} else {
					bw.write(maxNumber + "\n");
				}

			}
		}
		bw.flush();
	}
}
