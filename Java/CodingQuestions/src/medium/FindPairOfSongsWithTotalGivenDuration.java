package medium;

import java.util.ArrayList;
import java.util.List;

public class FindPairOfSongsWithTotalGivenDuration {

	public static void main(String[] args) {
		Song song1 = new Song("Song1", 45);
		Song song2 = new Song("Song2", 40);
		Song song3 = new Song("Song3", 50);
		Song song4 = new Song("Song4", 55);
		Song song5 = new Song("Song5", 75);
		Song song6 = new Song("Song6", 65);
		
		List<Song> songs = new ArrayList<>();
		songs.add(song1);songs.add(song2);songs.add(song3);songs.add(song4);songs.add(song5);songs.add(song6);
		
		find(songs, 2, 60);
	}

	private static void find(List<Song> songs, int count, int duration) {
		
		int c =1;
		
		List<List<Song>> pairs = new ArrayList<List<Song>>();
		for(int i=0; i<songs.size(); i++) {
			int j = i+1;
			List<Song> pair = new ArrayList<>();
			while(j<songs.size()) {
				if(songs.get(i).getDuration() + songs.get(j).getDuration() % duration == 60) {
					c++;
					pair.add(songs.get(i));
					pair.add(songs.get(j));
				}
				if(c == count) {
					pairs.add(pair);
					c-=1;
				}
				j++;
			}
		}
		int z = 0;
		for(List<Song> pair : pairs) {
			System.out.println("\nPair number: "+z);
			z++;
			System.out.println(pair.get(0));
			System.out.println(pair.get(1));
		}
	}
}
