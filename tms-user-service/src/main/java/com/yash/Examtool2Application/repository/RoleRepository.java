package com.yash.Examtool2Application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.Examtool2Application.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
