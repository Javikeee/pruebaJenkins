package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TutorialVO;
import com.example.demo.service.TutorialService;

@CrossOrigin
@RestController
public class TutorialController implements TutorialAPI{

	@Autowired
    private TutorialService tutorialService;

	public ResponseEntity<?> getAllTutorials() {
		return tutorialService.getAllTutorials();
	}

	public ResponseEntity<?> getTutorialById(String id) {
		return tutorialService.getTutorialById(id);
	}

	public ResponseEntity<?> findByPublished() {
		return tutorialService.findByPublished();
	}

	public ResponseEntity<?> newTutorial(TutorialVO tutorialVO) {
		return tutorialService.newTutorial(tutorialVO);
	}

	public ResponseEntity<?> updateTutorial(String id, TutorialVO tutorialVO) {
		return tutorialService.updateTutorial(id, tutorialVO);
	}

	public ResponseEntity<?> deleteTutorial(String id) {
		return tutorialService.deleteTutorial(id);
	}

	@Override
	public ResponseEntity<?> findByTitle(String title) {
		return tutorialService.findByTitle(title);
	}

	@Override
	public ResponseEntity<?> deleteAllTutorials() {
		return tutorialService.deleteAllTutorials();
	}

}
