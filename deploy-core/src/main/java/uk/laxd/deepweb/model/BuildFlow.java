package uk.laxd.deepweb.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lawrence on 16/02/16.
 */
@Entity
public class BuildFlow extends DatabaseObject {

    private String name;

    private Collection<BuildFlowStep> buildFlowSteps = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<BuildFlowStep> getBuildFlowSteps() {
        return buildFlowSteps;
    }

    public void setBuildFlowSteps(Collection<BuildFlowStep> buildFlowSteps) {
        this.buildFlowSteps = buildFlowSteps;
    }
}
