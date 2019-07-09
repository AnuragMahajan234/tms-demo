package com.yash.Examtool2Application.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Question model is used as a data traveler from layer to layer.
 * @author gunjan.khatri
 *
 */
@Entity
@Table(name="questions")
public class Question {

	/**
	 * This is the Id of the Question and acts as the primary key
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/**
	 * This is the question statement. It is the question that will be asked.
	 */
	@NotBlank(message="Must enter question")
	@Lob
	private String questionStmt;

	
	private String explanation;
	
	private Integer points;
	/**
	 * This is the date at which the question was created
	 */
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date created_at;
	/**
	 * The date at which the question was updated
	 */
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date updated_at;
	/**
	 * Id of the User who is creating the question
	 */
	private Integer created_by;
	/**
	 * Id of user that is updating the question
	 */
	private Integer updated_by;
	
	@ManyToMany
	private List<Test> tests;
	
	@OneToMany(mappedBy="question")
	private List<Option> options;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;
	
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionStmt() {
		return questionStmt;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public void setQuestionStmt(String questionStmt) {
		this.questionStmt = questionStmt;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}
	public Integer getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(Integer updated_by) {
		this.updated_by = updated_by;
	}
	public List<Test> getTests() {
		return tests;
	}
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@PrePersist
	public void onCreate() {
		this.created_at = new Date();
	}
	@PostUpdate
	public void onUpdate() {
		this.updated_at = new Date();
	}
}

