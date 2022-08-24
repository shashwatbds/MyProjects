package medium;

public class Song {

	private String name;
	private int duration;
	public Song(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Song [name=" + name + ", duration=" + duration + "]";
	}
	
	
	
}
