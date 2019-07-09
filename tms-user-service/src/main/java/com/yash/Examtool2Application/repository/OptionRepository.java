package com.yash.Examtool2Application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.Examtool2Application.domain.Option;
import com.yash.Examtool2Application.domain.Question;
import java.util.List;


@Repository
public interface  OptionRepository extends CrudRepository<Option, Long>{

	Iterable<Option> findByQuestion(Question question);
}
