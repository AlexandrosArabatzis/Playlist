package arabatzis;

import java.util.Iterator;
import java.util.LinkedList;

public class Album {

	private String name;
	private String artist;
	private LinkedList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new LinkedList<Song>();
	}

	public boolean addSong(String name, double time) {
		if (checkSong(name, this.songs) == false) {
			Song newSong = new Song(name, time);
			this.songs.add(newSong);
			return true;
		}
		return false;
	}

	public boolean addToPlaylist(String songName, LinkedList<Song> playlist) {
		if (checkSong(songName,playlist) == false) {
			Song song = findSong(songName);
			playlist.add(song);
			return true;
		}
		return false;
	}



	private boolean checkSong(String songName, LinkedList<Song> list) {
		Iterator<Song> songIterator = list.iterator();
		while (songIterator.hasNext()) {
			Song song = songIterator.next();
			if (song.getName().equals(songName)) {
				return true;
			}
		}
		return false;
	}

	private Song findSong(String songName) {
		Iterator<Song> songIterator = this.songs.iterator();
			while (songIterator.hasNext()) {
				Song song = songIterator.next();
				if (song.getName().equals(songName)) {
					return song;
				}
			}
		return null;
	}

}
