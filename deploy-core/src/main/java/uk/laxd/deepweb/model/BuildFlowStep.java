package uk.laxd.deepweb.model;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by lawrence on 24/02/16.
 */
@Entity
public class BuildFlowStep extends DatabaseObject {

	private BuildFlow buildFlow;

	private String executorName;

	private Collection<BuildFlowStepArgument> arguments;

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
