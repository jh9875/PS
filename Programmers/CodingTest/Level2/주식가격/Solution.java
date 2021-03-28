import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] prices) {
		int total = prices.length;
		int[] answer =new int[total];

		for (int i = 0; i < total; i++) {
			for (int j = i + 1; j < total; j++) {
				answer[i]++;
				if (prices[i] > prices[j])
					break;
			}
		}

		return answer;
	}
}