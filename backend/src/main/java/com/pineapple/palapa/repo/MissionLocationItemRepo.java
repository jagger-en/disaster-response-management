
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.MissionLocationItem;
import org.springframework.data.repository.CrudRepository;

public interface MissionLocationItemRepo extends CrudRepository<MissionLocationItem, Long>, MissionLocationItemRepoCustom {

}
