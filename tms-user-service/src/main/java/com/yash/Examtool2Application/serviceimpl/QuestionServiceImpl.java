package com.yash.Examtool2Application.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.Examtool2Application.domain.Question;
import com.yash.Examtool2Application.domain.User;
import com.yash.Examtool2Application.repository.QuestionRepository;
import com.yash.Examtool2Application.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question create(Question question) {
		
		return questionRepository.save(question);
	}

	@Override
	public void delete(Long id) {
		questionRepository.deleteById(id);
		
	}

	@Override
	public Question update(Question question) {
		
		return questionRepository.save(question);
	}

	@Override
	public Iterable<Question> list() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public Optional<Question> findByQuestionId(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id);
	}

}
