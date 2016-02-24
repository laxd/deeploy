package uk.laxd.deepweb.model;

/**
 * Created by lawrence on 24/02/16.
 */
public class BuildFlowStep extends DatabaseObject {
    private Long buildFlowId;
    private String type;

    public Long getBuildFlowId() {
        return buildFlowId;
    }

    public void setBuildFlowId(Long buildFlowId) {
        this.buildFlowId = buildFlowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
