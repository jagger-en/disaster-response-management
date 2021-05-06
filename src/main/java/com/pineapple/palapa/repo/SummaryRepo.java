
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.Summary;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepo extends CrudRepository<Summary, Long>, SummaryRepoCustom {


}