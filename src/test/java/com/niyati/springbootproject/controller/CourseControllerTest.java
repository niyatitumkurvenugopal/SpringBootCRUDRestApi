package com.niyati.springbootproject.controller;

import com.niyati.springbootproject.model.Course;
import com.niyati.springbootproject.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {


    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    void canGetAllCourse() {
        Long topicId = 1L;
        List<Course> detailsCourseExpected = new ArrayList<>(Arrays.asList(
                new Course("Java", "It is a programming language.", 1L),
                new Course("Python", "It is a programming language.", 1L)
        ));

        when(courseService.getAllCourses(1L)).thenReturn(detailsCourseExpected);

        List<Course> result = courseController.getAllCourses(topicId);
        assertEquals(detailsCourseExpected, result);
    }

    @Test
    void canAddNewCourse() {
        Long topicId = 1L;
        Course course = new Course("Java", "It is a programming language.", 1L);

        when(courseService.addCourse(course)).thenReturn(course);

        Course result = courseController.addCourse(topicId, course);
        assertEquals(course, result);
    }

    @Test
    void canUpdateCourse() {
        Long topicId = 1L;
        Long id = 1L;
        Course course = new Course("Java", "It is a programming language.", 1L);

        when(courseService.updateCourse(id, course)).thenReturn(course);

        Course result = courseController.updateCourse(course, topicId, id);
        assertEquals(course, result);
    }

    @Test
    void canDeleteCourse() {
        Long id = 1L;
        Course course = new Course("Java", "It is a programming language.", 1L);

        String result = courseController.deleteCourse(id);
        assertEquals("Deleted Successfully.", result);
    }


}








