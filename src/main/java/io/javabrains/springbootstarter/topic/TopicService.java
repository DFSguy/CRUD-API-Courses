package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import io.javabrains.springbootstarter.mysql.TopicData;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getValues(String id){
		return topicRepository.getValues(id);
	}
  
 public List<Topic> getAllTopics(){
	 List<Topic> topics = new ArrayList<>();
	 topicRepository.findAll().forEach(topics::add);
	 return topics;
 }
 public Optional<Topic> getTopic(String id) {
	 //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	return  topicRepository.findById(id);
 }
 public void addTopic(Topic topic){
	 topicRepository.save(topic);
 }
public void updateTopic(String id, Topic topic) {
	
	topicRepository.save(topic);
	//save can do both update
	//select * from topic where dsome 
}
public void deleteTopic(String id) {

	topicRepository.deleteById(id);
	
}
}
