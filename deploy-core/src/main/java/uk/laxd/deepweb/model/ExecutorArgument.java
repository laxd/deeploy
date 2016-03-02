package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 26/02/16.
 */
@DatabaseTable(tableName = Constants.DB.ExecutorArgument.TABLE_NAME)
public class ExecutorArgument extends DatabaseObject {

    @DatabaseField(columnName = Constants.DB.ExecutorArgument.NAME_COLUMN)
    private String name;

    @DatabaseField(columnName = Constants.DB.ExecutorArgument.DISPLAY_NAME_COLUMN)
    private String displayName;

    @DatabaseField(foreign = true)
    private Executor executor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
