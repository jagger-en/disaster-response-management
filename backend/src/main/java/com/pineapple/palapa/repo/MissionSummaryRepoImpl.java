package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.MissionSummary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class MissionSummaryRepoImpl implements MissionSummaryRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<MissionSummary> getAllMissionSummaries() {
        StoredProcedureQuery getAllMissionSummariesProc = em.createNamedStoredProcedureQuery("getAllMissionSummaries");
        return getAllMissionSummariesProc.getResultList();
    }
}
