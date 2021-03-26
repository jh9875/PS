위장
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42578

<br>

### 풀이

해시로 해결할 수 있는 문제다.

자바에서 HashMap을 사용하였으며, HashMap<String, Integer>의 형태로 <옷의 종류, 개수>로 Key, Value 짝을 이루었다.

HashMap을 만드는 과정은 아래와 같다.

~~~java
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
~~~

HashMap에는 <key, value> 쌍이 중복되지 않으므로 .get(key) + 1을 해주었다.

조합의 총 수는 아래와 같이 했다.

~~~java
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
~~~

정답의 모든 경우에 value+1을 곱해줬는데 이것은 옷의 가지 수 와 해당 옷을 입지 않는 경우의 수를 곱한것이다.

마지막에 ans -1을 한 이유는 모든 옷을 입지 않는 경우의 수를 뺀것이다.