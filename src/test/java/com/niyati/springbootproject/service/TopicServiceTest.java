package com.niyati.springbootproject.service;

import com.niyati.springbootproject.model.Topic;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest {

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private TopicService topicService;

    @Test
    void canGetAllTopics() {
        List<Topic> detailsExpected = new ArrayList<>(Arrays.asList(
                new Topic("Java", "It is a programming language."),
                new Topic("Python", "It is a programming language.")
        ));

        when(topicRepository.findAll()).thenReturn(detailsExpected);

        List<Topic> result = topicService.getAllTopics();
        assertEquals(detailsExpected, result);
    }

    @Test
    void findUserById() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");

        when(topicRepository.findById(id)).thenReturn(Optional.of(topic));

        Optional<Topic> expected = topicService.getTopic(id);
        assertThat(expected).isNotNull();
    }

    @Test
    void canAddNewTopic() {
        Topic topic = new Topic("Java", "It is a programming language.");

        when(topicRepository.save(topic)).thenReturn(topic);

        Topic result = topicService.addTopic(topic);
        assertEquals(topic, result);
    }

    @Test
    void canUpdateTopic() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");

        when(topicRepository.save(topic)).thenReturn(topic);

        Topic result = topicService.updateTopic(id, topic);
        assertEquals(topic, result);
    }

    @Test
    void canDeleteTopic() {
        Long id = 1L;
        Topic topic = new Topic("Java", "It is a programming language.");

        String result = topicService.deleteTopic(id);
        assertEquals("Deleted Successfully.", result);
    }

}