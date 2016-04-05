package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStepArgument.TABLE_NAME)
public class BuildFlowStepArgument extends DatabaseObject {

    @DatabaseField(columnName = Constants.DB.BuildFlowStepArgument.NAME_COLUMN)
    private String name;

    @DatabaseField(columnName = Constants.DB.BuildFlowStepArgument.VALUE_COLUMN)
    private String value;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "BUILD_FLOW_STEP_ID")
    private BuildFlowStep buildFlowStep;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildFlowStep getBuildFlowStep() {
        return buildFlowStep;
    }

    public void setBuildFlowStep(BuildFlowStep buildFlowStep) {
        this.buildFlowStep = buildFlowStep;
    }
}
