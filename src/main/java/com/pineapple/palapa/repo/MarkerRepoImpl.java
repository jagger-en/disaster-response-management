package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.Marker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class MarkerRepoImpl implements MarkerRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Marker> getAllMarkers() {
        List<Marker> the_output = null;
        try {
            StoredProcedureQuery getAllMarkersProc = em.createNamedStoredProcedureQuery("getAllMarkers");
            the_output = getAllMarkersProc.getResultList();
        } catch (Exception e) {
            System.out.println("NO!!!!!!! MarkerRepoImpl");
            System.out.println(e);
        }
        
        return the_output;
    }
}