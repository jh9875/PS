import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    class SumInfo implements Comparable<SumInfo> {
        String genre;
        int sum;

        SumInfo(String genre, int sum) {
            this.genre = genre;
            this.sum = sum;
        }

        @Override
        public int compareTo(SumInfo o) {
            return this.sum - o.sum;
        }
    }

    class PlayInfo implements Comparable<PlayInfo> {
        int index;
        int play;

        PlayInfo(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(PlayInfo pi) {
            return this.play - pi.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<SumInfo> sumInfoList = new ArrayList<>();
        HashMap<String, List<PlayInfo>> infoHashMap = new HashMap<>();
        int len = genres.length;

        for (int i = 0; i < len; i++) {
            String key = genres[i];

            if (!infoHashMap.containsKey(key)) {
                sumInfoList.add(new SumInfo(key, plays[i]));

                List<PlayInfo> infoList = new ArrayList<>();
                infoList.add(new PlayInfo(i, plays[i]));
                infoHashMap.put(key, infoList);
            } else {
                for (SumInfo si : sumInfoList) {
                    if (si.genre.equals(key)) {
                        si.sum += plays[i];
                        break;
                    }
                }

                List<PlayInfo> infoList = infoHashMap.get(key);
                infoList.add(new PlayInfo(i, plays[i]));
                infoHashMap.put(key, infoList);
            }
        }

        Collections.sort(sumInfoList, Collections.reverseOrder());

        for (SumInfo si : sumInfoList) {
            String key = si.genre;

            List<PlayInfo> list = infoHashMap.get(key);
            Collections.sort(list, Collections.reverseOrder());

            answer.add(list.get(0).index);
            if (list.size() > 1)
                answer.add(list.get(1).index);

        }

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}