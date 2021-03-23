import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum = 0;
        int index = 0;
        List<Integer> truckInBridge = new ArrayList<>();
        Queue<Integer> trucks = new LinkedList<>();

        while (true) {
            if (index < truck_weights.length && weightSum + truck_weights[index] <= weight) {
                truckInBridge.add(0);
                trucks.add(truck_weights[index]);
                weightSum += truck_weights[index++];
            }

            truckInBridge = truckInBridge.stream().map(i -> i + 1).collect(Collectors.toList());
            answer++;

            if (!truckInBridge.isEmpty() && truckInBridge.get(0) >= bridge_length) {
                truckInBridge.remove(0);
                weightSum -= trucks.poll();
            }

            if (truckInBridge.isEmpty() && index == truck_weights.length)
                break;
        }

        return answer + 1;
    }
}