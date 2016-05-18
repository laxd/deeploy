package uk.laxd.deepweb.model;

import javax.persistence.Entity;

/**
 * Created by lawrence on 24/02/16.
 */
@Entity
public class BuildFlowStepArgument extends DatabaseObject {

    private String name;

    private String value;

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
