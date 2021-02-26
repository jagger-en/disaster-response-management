package com.pineapple.palapa.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Gender;
import com.pineapple.palapa.service.GenderService;

import java.util.List;

@RestController
@RequestMapping("/genders") 
public class GenderController {

    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderService.findAllGenders();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable("id") Long id) {
        Gender gender = genderService.findGenderById(id);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gender> addGender(@RequestBody Gender gender) {
        Gender newGender = genderService.addGender(gender);
        return new ResponseEntity<>(gender, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGender(@PathVariable("id") Long id) {
        genderService.deleteGender(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}