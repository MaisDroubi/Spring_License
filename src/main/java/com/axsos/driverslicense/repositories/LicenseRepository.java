package com.axsos.driverslicense.repositories;

import com.axsos.driverslicense.models.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
    void deleteById(Long id);
    License findTopByOrderByNumberDesc();
}
