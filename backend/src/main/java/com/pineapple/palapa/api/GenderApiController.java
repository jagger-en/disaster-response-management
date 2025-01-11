package com.pineapple.palapa.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pineapple.palapa.model.Gender;
import com.pineapple.palapa.service.GenderService;

import java.util.List;

@RestController
@RequestMapping("/api/gender")
public class GenderApiController {

    private final GenderService genderService;

    public GenderApiController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderService.findAllGenders();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gender> addGender(@RequestBody Gender gender) {
        Gender newGender = genderService.addGender(gender);
        return new ResponseEntity<>(newGender, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGender(@PathVariable("id") Long id) {
        genderService.deleteGender(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
