package com.pineapple.palapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getAllMarkers",
                                procedureName = "get_ultra_query",
    resultClasses = Marker.class)
})
public class Marker {
    @Id
    private String id;
    private String pointName;
    private String locationName;
    private String latitude;
    private String longitude;
    private String pointTypeName;

    private String missionName;
    private String teamName;

    public Marker() {}


    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
    
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    public String getlatitude() {
        return latitude;
    }

    public void setlatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public String getPointTypeName() {
        return pointTypeName;
    }

    public void setPointTypeName(String pointTypeName) {
        this.pointTypeName = pointTypeName;
    }
    
    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
