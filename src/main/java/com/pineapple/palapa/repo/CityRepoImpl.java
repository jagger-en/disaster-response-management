package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class CityRepoImpl implements CityRepoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<City> getAllCities() {
        StoredProcedureQuery findByYearProcedure =
                em.createNamedStoredProcedureQuery("getAllCities");
        return findByYearProcedure.getResultList();
    }
}