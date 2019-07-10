package com.yash.tms.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.yash.tms.domain.User;
import com.yash.tms.exception.LoginnameException;
import com.yash.tms.repository.UserRepository;
import com.yash.tms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public final Integer USER_STATUS_ACTIVE = 1;
	public final Integer USER_STATUS_BLOCKED = 2;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {

		userRepository.deleteById(id);

	}

	@Override
	public User authenticate(String loginname, String password) {

		try {
			User user = userRepository.findByLoginname(loginname);
			if (user == null) {
				throw new LoginnameException("User with Loginname : '" + loginname + "' does not exist!!");
			}
			if (user.getId() == USER_STATUS_BLOCKED) {
				throw new LoginnameException("You are blocked. Contact admin for more information");
			} else {
				if (user.getLoginname().equals(loginname) && user.getPassword().equals(password)) {
					return user;
				} else {
					throw new LoginnameException("You have entered inccorect Password. Please enter the correct Password");
				}
			}

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findByUserId(Integer id) {
		return userRepository.findById(id);
	}

	public User findUserByLoginname(String loginname) {
		return userRepository.findByLoginname(loginname);
	}

}
