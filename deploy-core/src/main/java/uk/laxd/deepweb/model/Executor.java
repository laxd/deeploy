package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 26/02/16.
 */
@DatabaseTable(tableName = Constants.DB.Executor.TABLE_NAME)
public class Executor extends DatabaseObject {

    @DatabaseField(columnName = Constants.DB.Executor.TYPE_COLUMN)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
