package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.TeamMissionDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class TeamMissionDetailsRepoImpl implements TeamMissionDetailsRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<TeamMissionDetails> getAllTeamMissionDetails() {
        StoredProcedureQuery getAllTeamMissionDetailsProc = em.createNamedStoredProcedureQuery("getAllTeamMissionDetails");
        return getAllTeamMissionDetailsProc.getResultList();
    }
}