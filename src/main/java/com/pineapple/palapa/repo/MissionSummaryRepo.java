
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.MissionSummary;
import org.springframework.data.repository.CrudRepository;

public interface MissionSummaryRepo extends CrudRepository<MissionSummary, Long>, MissionSummaryRepoCustom {

}
