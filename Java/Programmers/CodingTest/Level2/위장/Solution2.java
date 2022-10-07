import java.util.HashMap;
import java.util.Iterator;

class Solution {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> clothesHashMap = getClothesCount(clothes);
		return getNumOfCombination(clothesHashMap);
	}

	public HashMap<String, Integer> getClothesCount(String[][] clothes) {
		HashMap<String, Integer> clothesHashMap = new HashMap<>();

		for (String[] someClothes : clothes) {
			String key = someClothes[1];

			if (clothesHashMap.containsKey(key)) {
				clothesHashMap.put(key, clothesHashMap.get(key) + 1);
			} else {
				clothesHashMap.put(key, 1);
			}
		}

		return clothesHashMap;
	}

	public int getNumOfCombination(HashMap<String, Integer> clothesHashMap) {
		int ans = 1;
		Iterator<String> keys = clothesHashMap.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			int value = clothesHashMap.get(key);
			ans *= value + 1;
		}
		// 모든 경우의 수 = (옷의종류+입지않음) =value+1

		return ans - 1; // -1 : 아무것도 안입는 경우
	}

}