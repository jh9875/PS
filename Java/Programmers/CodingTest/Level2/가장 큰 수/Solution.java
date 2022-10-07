import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
	public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		List<String> strNumberList = new ArrayList<>();

		for (int num : numbers)
			strNumberList.add(String.valueOf(num));
		Collections.sort(strNumberList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		for (String strNum : strNumberList)
			sb.append(strNum);

		return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
	}
}