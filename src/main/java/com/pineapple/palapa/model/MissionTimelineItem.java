package com.pineapple.palapa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getAllMissionTimelineItem",
                                procedureName = "get_all_mission_timeline_item",
    resultClasses = MissionTimelineItem.class)
})
public class MissionTimelineItem implements Serializable {
    @Id
    private String id;
    private String missionName;
    private String missionDescription;
    private String statusName;
    private String statusBackground;
    private String assignmentDate;

    public MissionTimelineItem() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusBackground() {
        return statusBackground;
    }

    public void setStatusBackground(String statusBackground) {
        this.statusBackground = statusBackground;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }
}
