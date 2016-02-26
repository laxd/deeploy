package uk.laxd.deepweb.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStep.TABLE_NAME)
public class BuildFlowStep extends DatabaseObject {

    @DatabaseField(columnName = Constants.DB.BuildFlowStep.BUILD_FLOW_ID_COLUMN)
    private Long buildFlowId;

    @DatabaseField(columnName = Constants.DB.BuildFlowStep.EXECUTOR_ID_COLUMN)
    private Long executorId;

    public Long getBuildFlowId() {
        return buildFlowId;
    }

    public void setBuildFlowId(Long buildFlowId) {
        this.buildFlowId = buildFlowId;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }
}
