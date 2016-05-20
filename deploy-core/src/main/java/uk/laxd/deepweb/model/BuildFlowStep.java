package uk.laxd.deepweb.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lawrence on 24/02/16.
 */
@Entity
public class BuildFlowStep extends DatabaseObject {

	private String executorName;

	private Collection<BuildFlowStepArgument> arguments = new ArrayList<>();

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
