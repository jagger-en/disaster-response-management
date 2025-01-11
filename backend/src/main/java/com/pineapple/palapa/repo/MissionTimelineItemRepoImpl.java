package com.pineapple.palapa.repo;

import com.pineapple.palapa.model.MissionTimelineItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class MissionTimelineItemRepoImpl implements MissionTimelineItemRepoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MissionTimelineItem> getAllMissionTimelineItem() {
        StoredProcedureQuery getAllMissionTimelineItemProc = em.createNamedStoredProcedureQuery("getAllMissionTimelineItem");
        return getAllMissionTimelineItemProc.getResultList();
    }
}
