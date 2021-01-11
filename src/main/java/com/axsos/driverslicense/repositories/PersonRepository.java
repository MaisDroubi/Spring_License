package com.axsos.driverslicense.repositories;

import com.axsos.driverslicense.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    void deleteById(Long id);
    @Query(value = "SELECT * FROM persons WHERE persons.id NOT IN(SELECT licenses.person_id FROM licenses)", nativeQuery = true)
    List<Person> findByNoLicense();
}
