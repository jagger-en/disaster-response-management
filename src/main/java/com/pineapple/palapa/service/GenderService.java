package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Gender;
import com.pineapple.palapa.repo.GenderRepo;

import java.util.List;

@Service
public class GenderService {
    private final GenderRepo genderRepo;

    @Autowired
    public GenderService(GenderRepo genderRepo) {
        this.genderRepo = genderRepo;
    }

    public Gender addGender(Gender gender) {
        return genderRepo.save(gender);
    }

    public List<Gender> findAllGenders() {
        return genderRepo.findAll();
    }

    public void deleteGender(Long id){
        Gender gender = genderRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Gender by id " + id + " was not found"));
        genderRepo.delete(gender);
    }
}
