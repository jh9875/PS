import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		int total = citations.length;
		Arrays.sort(citations);

        for(int index = 0; index < total; index++) {
            int h = citations[index];
			int count = total - index;
			if (h >= count)
				return count;
        }

		return 0;
	}
}