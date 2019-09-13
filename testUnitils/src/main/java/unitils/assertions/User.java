package unitils.assertions;

/**
 * application model class<br>
 * equals method is NOT implemented
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