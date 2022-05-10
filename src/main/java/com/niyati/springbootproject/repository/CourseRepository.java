package com.niyati.springbootproject.repository;

import com.niyati.springbootproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
     List<Course> findByTopicId(Long topicId);
}
