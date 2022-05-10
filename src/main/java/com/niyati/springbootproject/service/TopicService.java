package com.niyati.springbootproject.service;

import com.niyati.springbootproject.model.Topic;
import com.niyati.springbootproject.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;

    }

    public Optional<Topic> getTopic(Long id) {
        return topicRepository.findById(id);
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long topicId, Topic topic) {
        return topicRepository.save(topic);
    }

    public String deleteTopic(Long id) {
        topicRepository.deleteById(id);
        return "Deleted Successfully.";
    }
}
