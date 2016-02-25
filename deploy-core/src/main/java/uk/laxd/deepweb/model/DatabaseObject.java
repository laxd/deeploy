package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class DatabaseObject {

    @DatabaseField(id = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
