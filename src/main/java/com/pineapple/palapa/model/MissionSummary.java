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
    @NamedStoredProcedureQuery(name = "getAllMissionSummaries",
                                procedureName = "get_all_mission_summaries",
    resultClasses = MissionSummary.class)
})
public class MissionSummary implements Serializable {
    @Id
    private String id;
    private String missionName;
    private String missionDescription;
    private String locationName;
    private String latitude;
    private String longitude;
    private String statusName;
    private String statusBackground;
    private Integer numEmployees;

    public MissionSummary() {}

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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }
}
