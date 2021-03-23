import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> truckQueue = getTruckQueue(truck_weights);
		Queue<Integer> bridgeSecQueue = new LinkedList<>();
		Queue<Integer> bridgeWeightQueue = new LinkedList<>();
		int answer = 0, inBridgeSum = 0;
		int passedTrucks = 0, totalTrucks = truck_weights.length;

		while (passedTrucks < totalTrucks) {
			if (!bridgeSecQueue.isEmpty() && bridgeSecQueue.peek() >= bridge_length) {
				bridgeSecQueue.poll();
				inBridgeSum -= bridgeWeightQueue.poll();
				passedTrucks++;
			}
			if (!truckQueue.isEmpty() && inBridgeSum + truckQueue.peek() <= weight) {
				bridgeSecQueue.add(0);
				bridgeWeightQueue.add(truckQueue.peek());
				inBridgeSum += truckQueue.poll();
			}
			bridgeSecQueue = after1Sec(bridgeSecQueue);
			answer++;
		}

		return answer;
	}

	public Queue<Integer> getTruckQueue(int[] truckWeights) {
		Queue<Integer> queue = new LinkedList<>();

		for (int weight : truckWeights)
			queue.add(weight);

		return queue;
	}

	public Queue<Integer> after1Sec(Queue<Integer> bridgeSecQueue) {
		Queue<Integer> queue = new LinkedList<>();
		Iterator<Integer> it = bridgeSecQueue.iterator();

		while (it.hasNext()) {
			queue.add(it.next() + 1);
		}
		return queue;
	}
}