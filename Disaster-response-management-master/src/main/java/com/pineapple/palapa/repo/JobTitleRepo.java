package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.JobTitle;

import java.util.Optional;

public interface JobTitleRepo extends JpaRepository<JobTitle, Long> {
    Optional<JobTitle> findJobTitleById(Long id);
}
