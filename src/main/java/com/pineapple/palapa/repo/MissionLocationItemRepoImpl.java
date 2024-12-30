package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.MissionLocationItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class MissionLocationItemRepoImpl implements MissionLocationItemRepoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MissionLocationItem> getAllMissionLocationItem() {
        StoredProcedureQuery getAllMissionLocationItemProc = em.createNamedStoredProcedureQuery("getAllMissionLocationItem");
        return getAllMissionLocationItemProc.getResultList();
    }
}
