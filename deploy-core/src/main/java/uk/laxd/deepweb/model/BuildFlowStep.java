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

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "BUILD_FLOW_ID")
	private BuildFlow buildFlow;

	@DatabaseField(columnName = "EXECUTOR_NAME")
	private String executorName;

	@ForeignCollectionField(foreignFieldName = "buildFlowStep", eager = true)
	private ForeignCollection<BuildFlowStepArgument> arguments;

	public BuildFlow getBuildFlow() {
		return buildFlow;
	}

	public void setBuildFlow(BuildFlow buildFlow) {
		this.buildFlow = buildFlow;
	}

	public String getExecutorName() {
		return executorName;
	}

	public void setExecutorName(String executorName) {
		this.executorName = executorName;
	} 

	public Collection<BuildFlowStepArgument> getArguments() {
		return arguments;
	}

}
