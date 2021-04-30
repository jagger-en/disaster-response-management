package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.Point;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class PointRepoImpl implements PointRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Point> getAllPoints() {
        StoredProcedureQuery getAllPointsProc = em.createNamedStoredProcedureQuery("getAllPoints");
        return getAllPointsProc.getResultList();
    }
}