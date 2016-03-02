package uk.laxd.deepweb.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 16/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlow.TABLE_NAME)
public class BuildFlow extends DatabaseObject {

    @DatabaseField(columnName = Constants.DB.BuildFlow.NAME_COLUMN)
    private String name;

    @ForeignCollectionField
    private ForeignCollection<BuildFlowStep> buildFlowSteps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
