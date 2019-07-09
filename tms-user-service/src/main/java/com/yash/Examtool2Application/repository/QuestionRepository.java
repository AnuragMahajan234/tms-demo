package com.yash.Examtool2Application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.Examtool2Application.domain.Question;


@Repository
public interface  QuestionRepository extends CrudRepository<Question, Long>{

}
