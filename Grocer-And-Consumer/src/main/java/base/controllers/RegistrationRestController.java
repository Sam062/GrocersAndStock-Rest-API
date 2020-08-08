package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.model.GrocerModel;
import base.model.UserModel;
import base.service.IGrocerService;
import base.service.IUserService;
import base.service.UserServiceImpl;

@RestController
@RequestMapping("/register")
public class RegistrationRestController {
	@Autowired
	private IUserService service;

	@Autowired
	private IGrocerService grocerService;

	@PostMapping(value = "/grocer",
			consumes = "application/json",
			produces = "application/json"
			)
	public ResponseEntity registerGrocer(@RequestBody GrocerModel model){
		grocerService.saveGrocer(model);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PostMapping(value = "/user",
			consumes = "application/json",
			produces = "application/json"
			)
	public ResponseEntity registerUser(@RequestBody UserModel model){
		service.saveUser(model);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
}
