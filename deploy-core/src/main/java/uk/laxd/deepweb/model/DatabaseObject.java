package uk.laxd.deepweb.model;

import javax.persistence.Id;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class DatabaseObject {

    @Id
    private String id;

    public String getId() {
        return id;
    }
}
