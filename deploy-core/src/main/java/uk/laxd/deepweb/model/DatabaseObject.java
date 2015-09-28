package uk.laxd.deepweb.model;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class DatabaseObject {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
