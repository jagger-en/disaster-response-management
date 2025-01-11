package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.JobTitle;

public interface JobTitleRepo extends JpaRepository<JobTitle, Long> {

}
