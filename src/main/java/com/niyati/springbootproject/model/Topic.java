package com.niyati.springbootproject.model;

import javax.persistence.*;

@Entity
@Table
public class Topic {
    @Id
    @SequenceGenerator(name = "topic_sequence", sequenceName = "topic_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_sequence")
    private Long id;

    private String name;
    private String description;

    public Topic() {
    }

    public Topic(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Topic(String name, String description) {
        super();
        this.name = name;
        this.description = description;
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
