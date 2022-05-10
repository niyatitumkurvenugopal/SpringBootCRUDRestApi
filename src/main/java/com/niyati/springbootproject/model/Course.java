package com.niyati.springbootproject.model;

import javax.persistence.*;

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course( String name, String description, Long topicId) {
        super();
        this.name = name;
        this.description = description;
        this.topic=new Topic(topicId,"","");
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
