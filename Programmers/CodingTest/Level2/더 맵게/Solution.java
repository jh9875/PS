import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville)
            pq.add(n);

        while (!pq.isEmpty()) {
            int notSpicy1 = pq.poll();
            if (notSpicy1 >= K)
                break;

            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            
            int notSpicy2 = pq.poll();
            pq.add(notSpicy1 + (notSpicy2 * 2));
            answer++;
        }

        return answer;
    }
}