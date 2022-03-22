package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//@Autowired marks topicService as something that needs dependency injection
	@Autowired
	private TopicService topicService;
	
	// Return a list of Topic objects in JSON format
	// The generated JSON has key names corresponding to property names of the Topic class.
	// The JSON values are the values of those properties.
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	// map this method to any request that's a post on /topics
	@RequestMapping(method=RequestMethod.POST, value = "/topics")
	// pick topic instance from request body
	// @RequestBody tells spring MVC that the request payload contains JSON representation of this 
	// topic instance and take that request body and convert it into a topic instance and pass it
	// to the addTopic, then the URL is mapped
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{id}")
	public void updateTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
