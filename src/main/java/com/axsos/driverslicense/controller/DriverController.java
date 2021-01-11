package com.axsos.driverslicense.controller;


import com.axsos.driverslicense.models.License;
import com.axsos.driverslicense.models.Person;
import com.axsos.driverslicense.services.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }
    @RequestMapping("/")
    public String index(Model model){
        List<Person> people = driverService.allPeople();
        model.addAttribute("persons", people);
        return "license/index.jsp";
    }
    @RequestMapping("persons/new")
    public String addPerson(@ModelAttribute("person") Person person){
        return "license/addPerson.jsp";
    }

    @RequestMapping(value = "persons/new", method = RequestMethod.POST)
    public String creatPerson(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if(result.hasErrors()){
            return "license/addPerson.jsp";
        } else {
            driverService.addPerson(person);
            return "redirect:/";
        }
    }

    @RequestMapping("licenses/new")
    public String addLicense(Model model, @ModelAttribute("license")License license){
        List<Person> persons = driverService.findUnlicensed();
        model.addAttribute("persons", persons);
        return "license/addLicense.jsp";
    }
    @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, @RequestParam("person") Long id){
        if(result.hasErrors()){
            return "license/addLicense.jsp";
        } else{
            driverService.addLicense(id,license);
            return "redirect:/";
        }
    }

    @RequestMapping("persons/{id}")
    public String Show(Model model, @PathVariable("id") Long id){
        Person person = driverService.getPerson(id);
        model.addAttribute("person", person);
        return "license/show.jsp";
    }
}
