package com.niyati.springbootproject.repository;

import com.niyati.springbootproject.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
