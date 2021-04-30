
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.Point;
import org.springframework.data.repository.CrudRepository;

public interface PointRepo extends CrudRepository<Point, Long>, PointRepoCustom {


}