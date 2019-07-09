package com.yash.Examtool2Application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.Examtool2Application.domain.User;
import java.lang.String;
import java.util.List;

@Repository
public interface  UserRepository extends CrudRepository<User, Integer>{

	User findByLoginname(String loginname);
}
