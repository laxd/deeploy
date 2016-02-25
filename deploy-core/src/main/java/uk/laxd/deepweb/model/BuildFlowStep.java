package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStep.TABLE_NAME)
public class BuildFlowStep extends DatabaseObject {

    @DatabaseField
    private Long buildFlowId;

    @DatabaseField
    private String type;

    public Long getBuildFlowId() {
        return buildFlowId;
    }

    public void setBuildFlowId(Long buildFlowId) {
        this.buildFlowId = buildFlowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
