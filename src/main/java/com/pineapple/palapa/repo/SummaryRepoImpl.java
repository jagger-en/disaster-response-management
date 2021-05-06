package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.Summary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class SummaryRepoImpl implements SummaryRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Summary> getAllSummaries() {
        StoredProcedureQuery getAllSummariesProc = em.createNamedStoredProcedureQuery("getAllSummaries");
        return getAllSummariesProc.getResultList();
    }
}