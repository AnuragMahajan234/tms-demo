package com.yash.Examtool2Application.web;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.yash.Examtool2Application.command.LoginCommand;
import com.yash.Examtool2Application.domain.User;
import com.yash.Examtool2Application.serviceimpl.MapValidationErrorService;
import com.yash.Examtool2Application.serviceimpl.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@GetMapping("/listUser")
	public ResponseEntity<?> findAllUser() {
		Iterable<User> users = userServiceImpl.list();
		System.out.println(users);
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/listUser/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Optional<User> user = userServiceImpl.findByUserId(id);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> insertUser(@RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User user1 = userServiceImpl.register(user);
		return new ResponseEntity<User>(user1, HttpStatus.CREATED);
	}

	@DeleteMapping("/listUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		userServiceImpl.delete(id);
		return new ResponseEntity<String>("User ID  : '" + id + "' Deleted Successfully!!", HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> UpdateUser(@RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User user1 = userServiceImpl.register(user);
		return new ResponseEntity<User>(user1, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> signUp(@Valid @RequestBody LoginCommand loginCommand, BindingResult result,
			HttpSession session) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;

		User loggedinuser = userServiceImpl.authenticate(loginCommand.getLoginname(), loginCommand.getPassword());

		if (loggedinuser != null) {
			setLoggedInUserInSession(session, loggedinuser);
			return new ResponseEntity<User>(loggedinuser, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/authenticateUser")
	public ResponseEntity<?> signIn(@Valid @RequestBody LoginCommand loginCommand, BindingResult result,
			HttpSession session) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		
			User loggedinuser = userServiceImpl.authenticate(loginCommand.getLoginname(), loginCommand.getPassword());
			if (loggedinuser != null) {
				if (loggedinuser.getRole() == 1) {
					setLoggedInUserInSession(session, loggedinuser);
					return new ResponseEntity<User>(loggedinuser, HttpStatus.OK);
				} else if (loggedinuser.getRole() == 2) {
					setLoggedInUserInSession(session, loggedinuser);
					return new ResponseEntity<User>(loggedinuser, HttpStatus.OK);
				} else if (loggedinuser.getRole() ==3) {
					setLoggedInUserInSession(session, loggedinuser);
					return new ResponseEntity<User>(loggedinuser, HttpStatus.OK);
				} else {
					return new ResponseEntity("Invalid Role", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
	}


	private void setLoggedInUserInSession(HttpSession session, User loggedinuser) {
		session.setAttribute("loggedinuser", loggedinuser);
		session.setAttribute("id", loggedinuser.getId());
		session.setAttribute("role", loggedinuser.getId());
	}
}
