package com.yash.Examtool2Application.service;

import java.util.Optional;

import com.yash.Examtool2Application.domain.Question;
import com.yash.Examtool2Application.domain.User;

public interface QuestionService {

    public Question create(Question question);
	
	public void delete(Long id);
	
	public Question update(Question question);
	
	public Iterable<Question> list();
	
	public Optional<Question> findByQuestionId(Long id);
}
