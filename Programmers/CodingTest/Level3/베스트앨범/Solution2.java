import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Solution {
	class Music implements Comparable<Music> {
		int id;
		int play;
		String genre;

		Music(int id, int play, String genre) {
			this.id = id;
			this.play = play;
			this.genre = genre;
		}

		@Override
		public int compareTo(Music m) {
			if (this.play == m.play)
				return this.id - m.id;
			return m.play - this.play;
		}
	}

	class GenreInfo implements Comparable<GenreInfo> {
		String genre;
		int sum;

		GenreInfo(String genre, int sum) {
			this.genre = genre;
			this.sum = sum;
		}

		@Override
		public int compareTo(GenreInfo g) {
			return g.sum - this.sum;
		}
	}

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

	public List<Music> getMostPlayOrderedMusicList(String[] genres, int[] plays) {
		List<Music> musicList = new ArrayList<>();
		int numOfMusic = plays.length;
		for (int i = 0; i < numOfMusic; i++)
			musicList.add(new Music(i, plays[i], genres[i]));
		Collections.sort(musicList);
		return musicList;
	}

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
}