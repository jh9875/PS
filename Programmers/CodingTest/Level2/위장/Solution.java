import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int answer = 1;
        int len = clothes.length;

        for (int i = 0; i < len; i++) {
            String key = clothes[i][1];

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                hashMap.put(key, hashMap.get(key) + 1);
            }
        }

        Iterator<String> keys = hashMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            int value = hashMap.get(key);
            answer *= value + 1;
        }
        //��� ����� �� = (��������+��������) =value+1

        return answer - 1;      //�ƹ��͵� ������ ��� -1

    }
}