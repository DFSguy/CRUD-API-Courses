package io.javabrains.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TopicController {
	
	@Autowired 
	private TopicService topicService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	//select * from topic;
	 @RequestMapping("/topic/{id}")
	public List<Topic> getValues(@PathVariable String id){
		 log.debug("Entering the id value from topic");
		return topicService.getValues(id);
		}
	
	//select * from topic;
	 @RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		 log.info("User has entered the topics");
		return topicService.getAllTopics();
		}
	 //select * from topic where id="id";
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id){
		log.error("Error into the topic id");
		return topicService.getTopic(id);
	}
	//insert into topics (id, name, description) values( topic);
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//update topic set column = topic where id ="id";
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	//drop from topic where id ="id";
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		log.warn("Received delete request");
		topicService.deleteTopic(id);
	}
	
}
