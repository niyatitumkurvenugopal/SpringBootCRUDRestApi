package com.niyati.springbootproject.service;

import com.niyati.springbootproject.model.Course;
import com.niyati.springbootproject.model.Topic;
import com.niyati.springbootproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(Long topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id,Course course) {
         return courseRepository.save(course);
    }

    public String deleteCourse(Long id) {
        courseRepository.deleteById(id);
        return "Deleted Successfully.";
    }
}
