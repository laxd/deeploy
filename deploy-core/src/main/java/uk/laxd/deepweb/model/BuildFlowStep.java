package uk.laxd.deepweb.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import uk.laxd.deepweb.lang.Constants;

import java.util.Collection;

/**
 * Created by lawrence on 24/02/16.
 */
@DatabaseTable(tableName = Constants.DB.BuildFlowStep.TABLE_NAME)
public class BuildFlowStep extends DatabaseObject {

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private BuildFlow buildFlow;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Executor executor;

    @ForeignCollectionField()
    private ForeignCollection<BuildFlowStepArgument> arguments;

    public BuildFlow getBuildFlow() {
        return buildFlow;
    }

    public void setBuildFlow(BuildFlow buildFlow) {
        this.buildFlow = buildFlow;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Collection<BuildFlowStepArgument> getArguments() {
        return arguments;
    }

}
