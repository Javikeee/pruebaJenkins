package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.TutorialVO;


public interface TutorialAPI {

	//	GET
	
    @GetMapping("/tutorials")
    public ResponseEntity<?> getAllTutorials();

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<?> getTutorialById(@PathVariable String id);
    
    @GetMapping("/tutorials/publish")
    public ResponseEntity<?> findByPublished();
    
    @GetMapping("/tutorials/title/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title);
    
    //	POST
    
    @PostMapping("/tutorials")
    public ResponseEntity<?> newTutorial(@RequestBody TutorialVO tutorialVO);
    
    //	PUT
    
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<?> updateTutorial(@PathVariable String id, @RequestBody TutorialVO tutorialVO);
        
    //	DELETE
        
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<?> deleteTutorial(@PathVariable String id);
    
    @DeleteMapping("/tutorials/all")
    public ResponseEntity<?> deleteAllTutorials();
	
}
