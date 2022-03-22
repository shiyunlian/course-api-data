package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	// CrudRepository can handle all the methods below
	// getAllTopic()
	// getTopic(String id)
	// updateTopic(Topic t)
	// deleteTopic(String id)
	
//	public List<Course> findByName(String name);
//	public List<Course> findByDescription(String description);
	public List<Course> findByTopicId(String topicId);
	

}