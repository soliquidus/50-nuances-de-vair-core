package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Rubric;

public interface RubricRepository extends JpaRepository<Rubric, Long> {

}
