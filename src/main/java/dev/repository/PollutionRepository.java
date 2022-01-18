package dev.repository;

import dev.entity.Pollution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollutionRepository extends JpaRepository<Pollution,Long> {

}
