package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Rubric;
import dev.service.RubricService;

@RestController
@RequestMapping("rubrics")
public class RubricController {

	private RubricService rubricService;
	
	public RubricController(RubricService rubricService) {
		this.rubricService = rubricService;
	}
	
	@GetMapping
	public ResponseEntity<?> getRubrics() {
		return ResponseEntity.ok().body(this.rubricService.getRubrics());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRubric(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.rubricService.getRubric(id));
	}
	
	@PostMapping()
	public ResponseEntity<?> addRubric(@RequestBody Rubric rubric) {
		return ResponseEntity.ok().body(this.rubricService.addRubric(rubric));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRubric(@PathVariable Long id) {
		this.rubricService.deleteRubric(id);
		return ResponseEntity.ok().body(id);
	}
}
