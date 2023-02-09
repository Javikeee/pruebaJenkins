package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.TutorialVO;
import com.example.demo.model.domain.Tutorial;
import com.example.demo.repository.TutorialRepository;
import com.example.demo.service.TutorialService;
import com.example.demo.util.TutorialMapper;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;

	@Autowired
	private TutorialMapper tutorialMapper;

	public ResponseEntity<?> getAllTutorials() {

		List<Tutorial> tutorialList = tutorialRepository.findAll();

		if (tutorialList.isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			List<TutorialVO> voList = tutorialList.stream().map(tutorialMapper::fromPropertyToVO)
					.collect(Collectors.toList());

			return ResponseEntity.ok(voList);
		}
	}

	public ResponseEntity<?> getTutorialById(String id) {

		Tutorial tutorial = tutorialRepository.findById(id).orElse(null); // Busca al empleado del id indicado en
																			// PathVariable. De no encontrarlo devuelve
																			// null.

		if (tutorial == null) {

			return ResponseEntity.notFound().build(); // Devuelve un ResponseEntity 404 al no encontrarlo.

		} else {

			return ResponseEntity.ok(tutorial); // Devuelve un ResponseEntity 200 incluyendo el empleado encontrado.

		}

	}

	public ResponseEntity<?> findByPublished() {

		List<Tutorial> tutorialList = tutorialRepository.findAll();

		if (tutorialList.isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			List<TutorialVO> voList = tutorialList.stream().filter(e -> e.getPublished() == true)
					.map(tutorialMapper::fromPropertyToVO).collect(Collectors.toList());

			return ResponseEntity.ok(voList);
		}
	}

	public ResponseEntity<?> newTutorial(TutorialVO tutorialVO) {
		Tutorial newtutorial = new Tutorial();
		newtutorial.setId(tutorialVO.getId());
		newtutorial.setDescription(tutorialVO.getDescription());
		newtutorial.setPublished(tutorialVO.getPublished());
		newtutorial.setTitle(tutorialVO.getTitle());
		return ResponseEntity.status(HttpStatus.CREATED).body(tutorialRepository.save(newtutorial));
	}

	public ResponseEntity<?> updateTutorial(String id, TutorialVO tutorialVO) {

		return tutorialRepository.findById(id).map(p -> {

			p.setId(tutorialVO.getId());
			p.setTitle(tutorialVO.getTitle());
			p.setDescription(tutorialVO.getDescription());
			p.setPublished(tutorialVO.getPublished());

			return ResponseEntity.ok(tutorialRepository.save(p));

		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});
	}

	public ResponseEntity<?> deleteTutorial(String id) {

		if (tutorialRepository.existsById(id)) {
			tutorialRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@Override
	public ResponseEntity<?> findByTitle(String title) {
		List<Tutorial> tutorialList = tutorialRepository.findAll();

		if (tutorialList.isEmpty()) {

			return ResponseEntity.notFound().build();

		} else {

			List<TutorialVO> voList = tutorialList.stream().filter(e -> e.getTitle().equals(title))
					.map(tutorialMapper::fromPropertyToVO).collect(Collectors.toList());

			return ResponseEntity.ok(voList);
		}
	}

	@Override
	public ResponseEntity<?> deleteAllTutorials() {
		tutorialRepository.deleteAll();

		return ResponseEntity.noContent().build();
	}

}
