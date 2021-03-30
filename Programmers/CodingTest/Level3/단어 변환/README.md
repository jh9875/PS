단어 변환
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163

<br>

### 풀이

bfs로 해결 가능.

begin 단어에서부터 words에 있는 단어들 중 한 글자만 바꿀 수 있는 후보들을 queue에 담으면서 탐색.

~~~java
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
~~~

다음은 한 글자만 바꿀 수 있는지 확인하는 함수.

~~~java
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
~~~