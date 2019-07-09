package com.yash.Examtool2Application.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name="tests")
public class Test {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer duration;
	private Integer passingMarks;
	private Integer noOfQuestions;
	@OneToOne
	private Status visibility;
	@ManyToMany(mappedBy="tests")
	private List<Question> questions;
	
	@ManyToMany(mappedBy="tests",fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<TestGroup> groups;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	public Status getVisibility() {
		return visibility;
	}
	public void setVisibility(Status visibility) {
		this.visibility = visibility;
	}
	public List<TestGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<TestGroup> groups) {
		this.groups = groups;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getPassingMarks() {
		return passingMarks;
	}
	public void setPassingMarks(Integer passingMarks) {
		this.passingMarks = passingMarks;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public Integer getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(Integer noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
