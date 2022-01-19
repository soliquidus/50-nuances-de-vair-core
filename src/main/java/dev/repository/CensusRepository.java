package dev.repository;

import dev.entity.Census;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CensusRepository extends JpaRepository<Census,Long> {
}
