
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.Point;
import org.springframework.data.repository.CrudRepository;

public interface MarkerRepo extends CrudRepository<Point, Long>, MarkerRepoCustom {


}