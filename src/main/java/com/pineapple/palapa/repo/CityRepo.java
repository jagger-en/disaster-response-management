
package com.pineapple.palapa.repo;
import com.pineapple.palapa.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long>, CityRepoCustom {


}