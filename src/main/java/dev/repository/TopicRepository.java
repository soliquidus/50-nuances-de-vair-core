package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Topic;

public interface TopicRepository  extends JpaRepository<Topic, Long> {

}
