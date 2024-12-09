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
    @NamedStoredProcedureQuery(name = "getAllTeamMissionDetails",
                               procedureName = "get_all_team_mission_details_query",
    resultClasses = TeamMissionDetails.class)
})
public class TeamMissionDetails {
    @Id
    private String id;

    private String teamName;
    private String teamFunctionalityName;
    private String teamFunctionalityDescription;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeJobTitleName;
    private String missionName;
    private String missionDescription;
    private String missionTypeName;
    private String missionLocationName;

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamFunctionalityName() {
        return teamFunctionalityName;
    }

    public void setTeamFunctionalityName(String teamFunctionalityName) {
        this.teamFunctionalityName = teamFunctionalityName;
    }

    public String getTeamFunctionalityDescription() {
        return teamFunctionalityDescription;
    }

    public void setTeamFunctionalityDescription(String teamFunctionalityDescription) {
        this.teamFunctionalityDescription = teamFunctionalityDescription;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeJobTitleName() {
        return employeeJobTitleName;
    }

    public void setEmployeeJobTitleName(String employeeJobTitleName) {
        this.employeeJobTitleName = employeeJobTitleName;
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

    public String getMissionTypeName() {
        return missionTypeName;
    }

    public void setMissionTypeName(String missionTypeName) {
        this.missionTypeName = missionTypeName;
    }

    public String getMissionLocationName() {
        return missionLocationName;
    }

    public void setMissionLocationName(String missionLocationName) {
        this.missionLocationName = missionLocationName;
    }

    @Override
    public String toString() {
        return "TeamMissionDetails{" +
                "teamName='" + teamName + '\'' +
                ", teamFunctionalityName='" + teamFunctionalityName + '\'' +
                ", teamFunctionalityDescription='" + teamFunctionalityDescription + '\'' +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeJobTitleName='" + employeeJobTitleName + '\'' +
                ", missionName='" + missionName + '\'' +
                ", missionDescription='" + missionDescription + '\'' +
                ", missionTypeName='" + missionTypeName + '\'' +
                ", missionLocationName='" + missionLocationName + '\'' +
                '}';
    }
}
