package com.niyati.springbootproject.controller;

import com.niyati.springbootproject.model.Course;
import com.niyati.springbootproject.model.Topic;
import com.niyati.springbootproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable Long id) {
        return courseService.getAllCourses(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public Course addCourse(@PathVariable Long topicId,@RequestBody Course course) {
        course.setTopic(new Topic(topicId,"",""));
         return courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public Course updateCourse( @RequestBody Course course,@PathVariable Long topicId, @PathVariable Long id) {
        course.setTopic(new Topic(topicId,"",""));
        return courseService.updateCourse(topicId,course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Deleted Successfully.";
    }
}
