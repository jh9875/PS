베스트앨범
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42579

<br>

### 풀이

장르별 play가 높은 순으로 정렬된 리스트를 반환

~~~java
public List<GenreInfo> getMostPlayOrderedGenres(String[] genres, int[] plays) {
	List<GenreInfo> genreList = new ArrayList<>();
	HashMap<String, Integer> sumOnGenres = getSumOfGenres(genres, plays);
	Iterator<String> it = sumOnGenres.keySet().iterator();

	while (it.hasNext()) {
		String key = it.next();
		int value = sumOnGenres.get(key);
		genreList.add(new GenreInfo(key, value));
	}
	Collections.sort(genreList);
	return genreList;
}

public HashMap<String, Integer> getSumOfGenres(String[] genres, int[] plays) {
	HashMap<String, Integer> hashMap = new HashMap<>();
	int totalMusic = plays.length;

	for (int i = 0; i < totalMusic; i++) {
		String key = genres[i];
		if (hashMap.containsKey(key))
			hashMap.put(key, hashMap.get(key) + plays[i]);
		else
			hashMap.put(key, plays[i]);
	}
	return hashMap;
}
~~~

그 다음으로 정렬된 리스트 순으로 가장 많이 재생된 음악 최대 2개를 뽑기

~~~java
public int[] solution(String[] genres, int[] plays) {
	List<Integer> answer = new ArrayList<>();
	List<Music> sortedMusicList = getMostPlayOrderedMusicList(genres, plays);
	List<GenreInfo> sortedSumOfGenres = getMostPlayOrderedGenres(genres, plays);

	for (GenreInfo genreInfo : sortedSumOfGenres) {
		String someGenre = genreInfo.genre;
		List<Integer> mostPlayedMusic = getMostPlayedMusic(someGenre, sortedMusicList);
		for (int musicId : mostPlayedMusic)
			answer.add(musicId);
	}

	return answer.stream().mapToInt(i -> i.intValue()).toArray();
}

..

public List<Integer> getMostPlayedMusic(String someGenre, List<Music> musicList) {
	List<Integer> list = new ArrayList<>();
	int count = 0;

	for (Music music : musicList) {
		if (count == 2)
			break;
		if (music.genre.equals(someGenre)) {
			list.add(music.id);
			count++;
		}
	}

	return list;
}
~~~