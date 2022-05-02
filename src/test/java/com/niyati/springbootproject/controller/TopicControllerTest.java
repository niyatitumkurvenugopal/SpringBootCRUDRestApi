package com.niyati.springbootproject.controller;

import com.niyati.springbootproject.model.Topic;
import com.niyati.springbootproject.service.TopicService;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TopicControllerTest {
    @Mock
    private TopicService topicService;

    @InjectMocks
    private TopicController topicController;

    @Test
    void canGetAllTopics() {
        List<Topic> detailsExpected = new ArrayList<>(Arrays.asList(
                new Topic("Java", "It is a programming language."),
                new Topic("Python", "It is a programming language.")
        ));

        when(topicService.getAllTopics()).thenReturn(detailsExpected);

        List<Topic> result = topicController.getAllTopics();
        assertEquals(detailsExpected, result);
    }

    @Test
    void findUserById() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");

        when(topicService.getTopic(id)).thenReturn(Optional.of(topic));

        Optional<Topic> expected = topicController.getTopic(id);
        assertThat(expected).isNotNull();
    }

    @Test
    void canAddNewTopic() {
        Topic topic = new Topic("Java", "It is a programming language.");
        when(topicService.addTopic(topic)).thenReturn(topic);

        Topic result = topicController.addTopic(topic);
        assertEquals(topic, result);
    }

    @Test
    void canUpdateTopic() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");
        when(topicService.updateTopic(id, topic)).thenReturn(topic);

        Topic result = topicController.updateTopic(id, topic);
        assertEquals(topic, result);
    }

    @Test
    void canDeleteTopic() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");

        String result = topicController.deleteTopic(id);
        assertEquals("Deleted Successfully.", result);
    }

}