package com.example.explorecalijpa.repo;

import com.example.explorecalijpa.model.TourPackage;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface TourPackageRepository extends JpaAttributeConverter<TourPackage, String> {
}
