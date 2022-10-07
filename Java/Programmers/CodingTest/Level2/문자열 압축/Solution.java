class Solution {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;
		int maxLen = s.length();

		for (int compressLen = 1; compressLen <= maxLen; compressLen++) {
			String compressedWord = compressWord(compressLen, s);
			answer = Math.min(answer, compressedWord.length());
		}

		return answer;
	}

	public String compressWord(int compressLen, String word) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int wordLen = word.length();

		while (index < wordLen) {
			if (index + compressLen >= wordLen) {
				sb.append(word.substring(index));
				break;
			}
			String pattern = word.substring(index, index + compressLen);
			int count = repeatedPatternCount(index, compressLen, pattern, word);

			if (count != 1)
				sb.append(count);
			sb.append(pattern);

			index += count * compressLen;
		}

		return sb.toString();
	}

	public int repeatedPatternCount(int index, int compressLen, String pattern, String word) {
		int count = 0;
		int wordLen = word.length();

		while (index < wordLen) {
			if (index + compressLen > wordLen)
				break;

			if (pattern.equals(word.substring(index, index + compressLen))) {
				count++;
				index += compressLen;
			} else
				break;
		}

		return count;
	}
}