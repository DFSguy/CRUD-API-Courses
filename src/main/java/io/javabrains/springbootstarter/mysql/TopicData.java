package io.javabrains.springbootstarter.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.topic.Topic;

import java.util.List;

@Repository
public interface TopicData extends JpaRepository<Topic, String> {


}
