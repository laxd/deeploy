package uk.laxd.deepweb.model;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStepArgument extends DatabaseObject {
    private String name;
    private String value;
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
