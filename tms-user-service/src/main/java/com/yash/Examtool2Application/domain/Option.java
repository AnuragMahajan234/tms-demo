package com.yash.Examtool2Application.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="options")
public class Option {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Lob
	@NotBlank(message="option cannot be blank")
	private String optionStmt;
	private Boolean isAnswer;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Question question;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionStmt() {
		return optionStmt;
	}
	public void setOptionStmt(String optionStmt) {
		this.optionStmt = optionStmt;
	}
	@JsonIgnore
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Boolean getIsAnswer() {
		return isAnswer;
	}
	public void setIsAnswer(Boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
}