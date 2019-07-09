package com.yash.Examtool2Application.command;

import com.yash.Examtool2Application.domain.Question;

import java.util.List;

import com.yash.Examtool2Application.domain.Option;

public class QueAnsCommand {

	private Question question;
	
	private List<Option> options;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
}
