package com.pineapple.palapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pineapple.palapa.model.Person;
import com.pineapple.palapa.model.Gender;
import com.pineapple.palapa.service.PersonService;
import com.pineapple.palapa.service.GenderService;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;
    private GenderService genderService;

    public PersonController(PersonService personService, GenderService genderService) {
        this.personService = personService;
        this.genderService = genderService;
    }

    @GetMapping("")
    public String getAllPersons(Person person, Gender gender, Model model) {
        List<Person> persons = personService.findAllPersons();
        List<Gender> genders = genderService.findAllGenders();
        model.addAttribute("persons", persons);
        model.addAttribute("genders", genders);
        model.addAttribute("pageToRender", "/persons/createPersons");
        return "index";
    }

    @PostMapping("/add")
    public String addPerson(Person person, Model model) {
        personService.addPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}