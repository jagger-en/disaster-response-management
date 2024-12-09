
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.TeamMissionDetails;
import org.springframework.data.repository.CrudRepository;

public interface TeamMissionDetailsRepo extends CrudRepository<TeamMissionDetails, Long>, TeamMissionDetailsRepoCustom {


}
