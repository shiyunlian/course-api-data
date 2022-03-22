package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service marks this class as a business service when the appication starts up
//when it is a service, spring will create an instance and registers it
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	// create a method to return a list of Topic objects
	public List<Topic> getAllTopics(){
		// connect to the database, run a query to get all the topics, convert each of those rows into 
		// topic instances, get it back
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add); // method reference and lambda expression
		return topics;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	}
	
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
// below methods are used without topicRepository	
//	// create a static initialization block initializes topics to be this list
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("spring", "Spring Framework", "Spring Framework Description"),
//			new Topic("java", "Core Java", "Core Java Description"),
//			new Topic("javascript", "JavaScript", "JavaScript Description")));
//	public List<Topic> getAllTopics(){
//		return topics;
//	}
//	public Topic getTopic(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
//	}
//
//	public void addTopic(Topic topic) {
//		topics.add(topic);
//	}
//
//	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
//		
//	}
//
//	public void deleteTopic(String id) {
//		topics.removeIf(t->t.getId().equals(id));
//		
//	}
	
	
}
