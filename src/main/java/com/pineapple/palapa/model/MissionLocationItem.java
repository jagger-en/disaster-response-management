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
    @NamedStoredProcedureQuery(name = "getAllMissionLocationItem",
                                procedureName = "get_all_mission_location_item",
    resultClasses = MissionLocationItem.class)
})
public class MissionLocationItem implements Serializable {
    @Id
    private String id;
    private String missionName;
    private String missionDescription;
    private String latitude;
    private String longitude;

    public MissionLocationItem() {}

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
}