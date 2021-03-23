다디를 지나는 트럭
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583

<br>

### 풀이

대기트럭, 다리를 건너는 트럭의 걸린 시간, 다리를 건너는 트럭의 무게를 Queue에 넣어서 처리해줬다.

~~~java
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
~~~

현재 다리위에 있는 트럭의 무게 합과 들어가려는 트럭의 무게의 합이 다리가 견디는 무게 내에 있을 때, 새로운 트럭을 다리를 지나가도록 해준다.

1초가 지나고 다리 길이보다 많이 갔을 땐 지나간 트럭.

모든 트럭이 다리를 지나면 이 루프를 끝낸다.