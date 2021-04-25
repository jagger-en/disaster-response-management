
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepo extends CrudRepository<City, Long>, CityRepoCustom {


}