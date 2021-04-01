import java.util.Stack;

class Solution {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty() ? true : false;
	}
}