import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovillePQ = getscovillePQ(scoville);
		return minimumMix(scovillePQ, K);
	}

	public PriorityQueue<Integer> getscovillePQ(int[] scoville) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int num : scoville)
			pq.add(num);

		return pq;
	}

	public int minimumMix(PriorityQueue<Integer> scovillePQ, int K) {
		int ret = 0;

		while (!scovillePQ.isEmpty()) {
			int lowest = scovillePQ.peek();
			if (lowest >= K)
				break;

			// K보다 낮은 경우
			if (scovillePQ.size() > 1) {
				int first = scovillePQ.poll();
				int second = scovillePQ.poll();

				scovillePQ.add(first + (second * 2));
				ret++;
			} else {
				ret = -1;
				break;
			}

		}

		return ret;
	}

}