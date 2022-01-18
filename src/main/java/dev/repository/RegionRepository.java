package dev.repository;

import dev.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByRegionCode (String code);
}