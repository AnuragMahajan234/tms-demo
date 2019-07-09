package com.yash.Examtool2Application.service;

import java.util.List;
import java.util.Optional;

import com.yash.Examtool2Application.domain.Option;
import com.yash.Examtool2Application.domain.Question;
import com.yash.Examtool2Application.domain.User;

public interface OptionService {

    public Option create(Option option);
	
	public void delete(Long id);
	
	public Option update(Option option);
	
	public Iterable<Option> list();
	
	public Iterable<Option> findByQuestionId(Question question);
	
	public List<Option> createOptions(List<Option> options);
}
