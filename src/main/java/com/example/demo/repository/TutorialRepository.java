package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.domain.Tutorial;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
	
}
