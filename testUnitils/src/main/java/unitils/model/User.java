package unitils.model;

/**
 * application model class that does not implement equals method
 * 
 * @author CornelGhita
 * 
 */
public class User {

	private long id;
	private String first;
	private String last;

	public User(long id, String first, String last) {
		this.id = id;
		this.first = first;
		this.last = last;
	}

	public long getId() {
		return id;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
}