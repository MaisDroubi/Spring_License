package com.axsos.driverslicense.services;


import com.axsos.driverslicense.models.License;
import com.axsos.driverslicense.models.Person;
import com.axsos.driverslicense.repositories.LicenseRepository;
import com.axsos.driverslicense.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final PersonRepository personRepository;
    private final LicenseRepository licenseRepository;

    public DriverService(PersonRepository personRepository, LicenseRepository licenseRepository) {
        this.personRepository = personRepository;
        this.licenseRepository = licenseRepository;
    }
    public List<Person> allPeople(){
        return personRepository.findAll();
    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }
    public List<Person> findUnlicensed(){
        return personRepository.findByNoLicense();
    }
    public License addLicense(Long id,License license){
        license.setNumber(generateNumber());
        Person person = personRepository.findById(id).orElse(null);
        license.setPerson(person);
        return licenseRepository.save(license);
    }
    private int generateNumber(){
        License license = licenseRepository.findTopByOrderByNumberDesc();
        if(license == null){
            return 1;
        }
        int largestNumber = license.getNumber();
        largestNumber++;
        return largestNumber;
    }

}
