package com.yash.Examtool2Application.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.Examtool2Application.command.QueAnsCommand;
import com.yash.Examtool2Application.domain.Option;
import com.yash.Examtool2Application.domain.Question;
import com.yash.Examtool2Application.domain.User;
import com.yash.Examtool2Application.serviceimpl.MapValidationErrorService;
import com.yash.Examtool2Application.serviceimpl.OptionServiceImpl;
import com.yash.Examtool2Application.serviceimpl.QuestionServiceImpl;
import com.yash.Examtool2Application.serviceimpl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/questions")
public class QueOptController {

	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	@Autowired
	private OptionServiceImpl optionServiceImpl;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@GetMapping("")
	public ResponseEntity<?> findAllQuestion() {
		Iterable<Question> questions = questionServiceImpl.list();
		return new ResponseEntity<Iterable<Question>>(questions, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable long id) {
		Optional<Question> question = questionServiceImpl.findByQuestionId(id);
		return new ResponseEntity<Optional<Question>>(question, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> insertUser(@RequestBody QueAnsCommand queAnsCommand, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Question question = questionServiceImpl.create(queAnsCommand.getQuestion());
		List<Option> options = queAnsCommand.getOptions();
		for (Option option : options) {
			option.setQuestion(question);
			optionServiceImpl.create(option);
		}
		return new ResponseEntity<QueAnsCommand>(queAnsCommand, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long id){
		
		questionServiceImpl.delete(id);
		
		return new ResponseEntity<String>("Question ID  : '"+id+"' Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> UpdateUser(@RequestBody QueAnsCommand queAnsCommand, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Question question = questionServiceImpl.update(queAnsCommand.getQuestion());
		List<Option> options = queAnsCommand.getOptions();
		for (Option option : options) {
			option.setQuestion(question);
			optionServiceImpl.update(option);
		}
		return new ResponseEntity<QueAnsCommand>(queAnsCommand, HttpStatus.CREATED);
	}
}
