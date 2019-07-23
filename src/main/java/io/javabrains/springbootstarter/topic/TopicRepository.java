package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<Topic , String>{
	
	@Query(value="SELECT * from topic t where id =:ID",nativeQuery=true) 
	 List<Topic> getValues(@Param ("ID") String id);
}
