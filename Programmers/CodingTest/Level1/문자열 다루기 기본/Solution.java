import java.util.regex.Pattern;

class Solution {
	public boolean solution(String s) {
		if (isLength4Or6(s) && isContainsOnlyNumber(s))
			return true;
		return false;
	}

	public boolean isLength4Or6(String input) {
		if (input.length() == 4 || input.length() == 6)
			return true;
		return false;
	}

	public boolean isContainsOnlyNumber(String input) {
		String regex = "^[0-9]+$";
		return Pattern.matches(regex, input);
	}
}