package arabatzis;

import java.util.LinkedList;

public class Song {
	
	private String name;
	private double time;
	
	public Song(String name, double time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return this.name;
	}

	public double getTime() {
		return this.time;
	}
}
