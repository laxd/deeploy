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

    @DatabaseField(columnName = Constants.DB.ExecutorArgument.MANDATORY_COLUMN)
    private boolean mandatory;

    @DatabaseField(columnName = Constants.DB.ExecutorArgument.DEFAULT_COLUMN)
    private String defaultValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
