package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStepArgument.TABLE_NAME)
public class BuildFlowStepArgument extends DatabaseObject {
    @DatabaseField
    private String name;

    @DatabaseField
    private String value;

    @DatabaseField
    private Long buildFlowStepId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getBuildFlowStepId() {
        return buildFlowStepId;
    }

    public void setBuildFlowStepId(Long buildFlowStepId) {
        this.buildFlowStepId = buildFlowStepId;
    }
}
