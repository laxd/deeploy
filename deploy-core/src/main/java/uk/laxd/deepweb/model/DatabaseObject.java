package uk.laxd.deepweb.model;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class DatabaseObject {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
