package com.yash.Examtool2Application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.Examtool2Application.domain.Option;
import com.yash.Examtool2Application.domain.Question;
import com.yash.Examtool2Application.domain.User;
import com.yash.Examtool2Application.repository.OptionRepository;
import com.yash.Examtool2Application.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService{

	@Autowired
	private OptionRepository optionRepository;

	@Override
	public Option create(Option option) {
		return optionRepository.save(option);
	}

	@Override
	public void delete(Long id) {
		optionRepository.deleteById(id);
		
	}

	@Override
	public Option update(Option option) {
		return optionRepository.save(option);
	}

	@Override
	public Iterable<Option> list() {
		return optionRepository.findAll();
	}

	@Override
	public Iterable<Option> findByQuestionId(Question question) {
		return optionRepository.findByQuestion(question);
	}
	
	@Override
	public List<Option> createOptions(List<Option> options) {
		
		List<Option> optionlist = new ArrayList();
				
		for (Option option2 : options) {
			create(option2);
			optionlist.add(option2);
		}
		return optionlist;
	}
}
