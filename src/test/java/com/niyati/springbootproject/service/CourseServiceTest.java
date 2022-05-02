package com.niyati.springbootproject.service;

import com.niyati.springbootproject.model.Course;
import com.niyati.springbootproject.model.Topic;
import com.niyati.springbootproject.repository.CourseRepository;
import com.niyati.springbootproject.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    void canGetAllCourse() {
        Long topicId=1L;
        List<Course> detailsCourseExpected = new ArrayList<>(Arrays.asList(
                new Course( "Java", "It is a programming language.",1L),
                new Course( "Python", "It is a programming language.",1L)
        ));

        when(courseRepository.findByTopicId(1L)).thenReturn(detailsCourseExpected);

        List<Course> result = courseService.getAllCourses(topicId);
        assertEquals(detailsCourseExpected, result);
    }

    @Test
    void canAddNewCourse() {
        Course course = new Course( "Java", "It is a programming language.",1L);

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseService.addCourse(course);
        assertEquals(course, result);
    }

    @Test
    void canUpdateCourse() {
        Long id=1L;
        Course course = new Course( "Java", "It is a programming language.",1L);

        when(courseRepository.save(course)).thenReturn(course);

        Course result = courseService.updateCourse(id,course);
        assertEquals(course, result);
    }

    @Test
    void canDeleteCourse() {
        Long id=1L;
        Course course = new Course( "Java", "It is a programming language.",1L);

        String result = courseService.deleteCourse(id);
        assertEquals("Deleted Successfully.", result);
    }

}