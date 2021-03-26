class Solution {
	public int[] solution(int brown, int yellow) {
		int total = brown + yellow;
		int width = 0, height = 0;
		int widthHeightSum = (brown + 4) / 2;

		while (height < total) {
			width = widthHeightSum - height;
			if (height * width == total)
				break;
			height++;

		}
		return new int[] { width, height };
	}
}