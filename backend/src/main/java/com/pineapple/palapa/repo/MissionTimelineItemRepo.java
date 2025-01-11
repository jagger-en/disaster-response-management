
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.MissionTimelineItem;
import org.springframework.data.repository.CrudRepository;

public interface MissionTimelineItemRepo extends CrudRepository<MissionTimelineItem, Long>, MissionTimelineItemRepoCustom {

}
