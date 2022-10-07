import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Word {
		String word;
		int count;

		Word(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	public int solution(String begin, String target, String[] words) {
		return bfs(begin, target, words);
	}

	public int bfs(String begin, String target, String[] words) {
		Queue<Word> queue = new LinkedList<>();
		int len = words.length;
		boolean[] used = new boolean[len];

		queue.add(new Word(begin, 0));

		while (!queue.isEmpty()) {
			String word = queue.peek().word;
			int count = queue.peek().count;
			queue.poll();

			if (word.equals(target))
				return count;

			for (int i = 0; i < len; i++) {
				if (canChangeOneAlphabet(word, words[i]) && !used[i]) {
					used[i] = true;
					queue.add(new Word(words[i], count + 1));
				}
			}
		}

		return 0;
	}

	public boolean canChangeOneAlphabet(String before, String after) {
		int len = before.length();
		boolean changed = false;

		for (int i = 0; i < len; i++) {
			if (before.charAt(i) != after.charAt(i)) {
				if (changed)
					return false;
				else
					changed = true;
			}
		}

		return true;
	}
}