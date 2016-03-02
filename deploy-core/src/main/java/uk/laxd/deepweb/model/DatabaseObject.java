package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by Lenny on 20/09/2015.
 */
public abstract class DatabaseObject {

    @DatabaseField(columnName = Constants.DB.ID_COLUMN, generatedId = true)
    private Long id;

    public Long getId() {
        return id;
    }
}
