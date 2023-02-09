package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.TutorialVO;

public interface TutorialService {

	public ResponseEntity<?> getAllTutorials();

	public ResponseEntity<?> getTutorialById(String id);

	public ResponseEntity<?> findByPublished();

	public ResponseEntity<?> newTutorial(TutorialVO tutorialVO);

	public ResponseEntity<?> updateTutorial(String id, TutorialVO tutorialVO);

	public ResponseEntity<?> deleteTutorial(String id);

	public ResponseEntity<?> findByTitle(String title);

	public ResponseEntity<?> deleteAllTutorials();

}
