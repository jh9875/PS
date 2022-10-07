문자열 압축
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/60057

<br>

### 풀이

문제 그대로 구현하면 되는 문제이다.

압축할 수 있는 길이는 1부터 문자열의 길이 까지이다. <br>
1부터 문자열의 길이까지 모든 길이로 압축해본 다음 문자열의 길이가 가장 짧은 길이를 반환한다.

~~~java
public int solution(String s) {
	int answer = Integer.MAX_VALUE;
	int maxLen = s.length();

	for (int compressLen = 1; compressLen <= maxLen; compressLen++) {
		String compressedWord = compressWord(compressLen, s);
		answer = Math.min(answer, compressedWord.length());
	}

	return answer;
}
~~~
<br>

문자열의 처음부터 끝까지 index로 살피면서 패턴이 반복되는지 확인한다. <br>
반복되는 패턴이 1이상이라면 숫자와 패턴을 함께 붙임. <br>
index는 반복된 패턴과 압축길이의 곱만큼 증가.

~~~java
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
~~~
