package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entity.Rubric;
import dev.repository.RubricRepository;

@Service
public class RubricService {
	
	private RubricRepository rubricRepository;
	
	public RubricService(RubricRepository rubricRepository) {
		this.rubricRepository = rubricRepository;
	}
	
	public List<Rubric> getRubrics() {
		return this.rubricRepository.findAll();
	}
	
	public Rubric getRubric(Long id) {
		return this.rubricRepository.getById(id);
	}
	
	@Transactional
	public Rubric addRubric(Rubric rubric) {
		return this.rubricRepository.save(rubric);
	}
	
	@Transactional
	public void deleteRubric(Long id) {
		this.rubricRepository.deleteById(id);
	}

}
