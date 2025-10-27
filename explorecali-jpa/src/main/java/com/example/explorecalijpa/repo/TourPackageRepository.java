package com.example.explorecalijpa.repo;

import com.example.explorecalijpa.model.TourPackage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="package", collectionResourceRel = "package")
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
  Optional<TourPackage> findByName(String name);
}
