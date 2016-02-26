package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStepArgument.TABLE_NAME)
public class BuildFlowStepArgument extends DatabaseObject {
    @DatabaseField(columnName = Constants.DB.BuildFlowStepArgument.VALUE_COLUMN)
    private String value;

    @DatabaseField(columnName = Constants.DB.BuildFlowStepArgument.EXECUTOR_ARGUMENT_ID_COLUMN)
    private Long executorArgumentId;

    @DatabaseField(columnName = Constants.DB.BuildFlowStepArgument.BUILD_FLOW_STEP_ID_COLUMN)
    private Long buildFlowStepId;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getExecutorArgumentId() {
        return executorArgumentId;
    }

    public void setExecutorArgumentId(Long executorArgumentId) {
        this.executorArgumentId = executorArgumentId;
    }

    public Long getBuildFlowStepId() {
        return buildFlowStepId;
    }

    public void setBuildFlowStepId(Long buildFlowStepId) {
        this.buildFlowStepId = buildFlowStepId;
    }
}
