package arabatzis;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static void printMenu() {
		System.out.println("Available actions:\npress");
		System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - to play previous song\n"
				+ "3 - to replay the current song\n" + "4 - list songs in the playlist\n"
				+ "5 - print available actions.\n" + "6 - delete current song from playlist");
	}

	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> songIterator = playlist.iterator();
		while (songIterator.hasNext()) {
			Song song = songIterator.next();
			String songName = song.getName();
			System.out.println(songName);
		}
	}

	private static void play(LinkedList<Song> playlist) {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		boolean wentForward = true;

		ListIterator<Song> songIterator = playlist.listIterator();

		while (running) {
			int action = scanner.nextInt();
			switch (action) {
			case 0:
				System.out.println("Quit program");
				break;
			case 1:
				if (songIterator.hasNext() && wentForward == true) {
					Song song = songIterator.next();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
				} else if (songIterator.hasNext() && wentForward == false) {
					songIterator.next();
					Song song = songIterator.next();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
					wentForward = true;
				} else {
					System.out.println("You reached the end of the playlist");
				}
				break;
			case 2:
				if (songIterator.hasPrevious() && wentForward == false) {
					Song song = songIterator.previous();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
				} else if (songIterator.hasPrevious() && wentForward == true) {
					songIterator.previous();
					Song song = songIterator.previous();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
					wentForward = false;
				} else {
					System.out.println("You reached the beginning of the playlist");
				}
				break;
			case 3:
				if (wentForward == true) {
					Song song = songIterator.previous();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
					songIterator.next();
				} else if (wentForward == false) {
					Song song = songIterator.next();
					System.out.println("Now playing: " + song.getName() + " Time: " + song.getTime());
					songIterator.previous();
				} else {
					System.out.println("Sorry, could not perform requested action");
				}
				break;
			case 4:
				printList(playlist);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if (playlist.size() > 0) {
					songIterator.remove();
					if (songIterator.hasNext()) {
						System.out.println("Now playing " + songIterator.next());
					} else if (songIterator.hasPrevious()) {
						System.out.println("Now playing " + songIterator.previous());
					}
				}
				break;
			}
		}

	}

	public static void main(String[] args) {

		LinkedList<Song> playList = new LinkedList<Song>();

		Album stormbringer = new Album("Stormbringer", "Deep Purple");
		stormbringer.addSong("Stormbringer", 4.6);
		stormbringer.addSong("Love don't mean a thing", 4.22);
		stormbringer.addSong("Holy man", 4.3);
		stormbringer.addSong("Hold on", 5.6);
		stormbringer.addSong("Lady double dealer", 3.21);
		stormbringer.addSong("You can't do it right", 6.23);
		stormbringer.addSong("High ball shooter", 4.27);
		stormbringer.addSong("The gypsy", 4.2);
		stormbringer.addSong("Soldier of fortune", 3.13);

		Album forThoseAboutToRock = new Album("For those about to rock", "AC/DC");
		forThoseAboutToRock.addSong("For those about to rock", 5.44);
		forThoseAboutToRock.addSong("I put the finger on you", 3.25);
		forThoseAboutToRock.addSong("Lets go", 3.45);
		forThoseAboutToRock.addSong("Inject the venom", 3.33);
		forThoseAboutToRock.addSong("Snowballed", 4.51);
		forThoseAboutToRock.addSong("Evil walks", 3.45);
		forThoseAboutToRock.addSong("C.O.D.", 5.25);
		forThoseAboutToRock.addSong("Breaking the rules", 5.32);
		forThoseAboutToRock.addSong("Night of the long knives", 5.12);

		stormbringer.addToPlaylist("Love don't mean a thing", playList);
		stormbringer.addToPlaylist("The gypsy", playList);
		stormbringer.addToPlaylist("Soldier of fortune", playList);
		stormbringer.addToPlaylist("Hold on", playList);
		forThoseAboutToRock.addToPlaylist("Snowballed", playList);
		forThoseAboutToRock.addToPlaylist("Night of the long knives", playList);
		forThoseAboutToRock.addToPlaylist("Breaking the rules", playList);
		forThoseAboutToRock.addToPlaylist("Evil walks", playList);

		play(playList);

	}

}
