package com.example.explorecalijpa.repo;

import com.example.explorecalijpa.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="staff", collectionResourceRel = "staff")
public interface StaffRepo extends JpaRepository<Staff, Integer> {
}
