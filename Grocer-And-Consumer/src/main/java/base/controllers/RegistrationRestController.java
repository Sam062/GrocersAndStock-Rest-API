package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.entity.GrocerEntity;
import base.entity.UserEntity;
import base.model.GrocerModel;
import base.model.UserModel;
import base.service.IGrocerService;
import base.service.IUserService;

@RestController
@RequestMapping("/register")
public class RegistrationRestController {
	@Autowired
	private IUserService service;

	@Autowired
	private IGrocerService grocerService;

	@PostMapping(value = "/grocer",
			consumes = "application/json"
			)
	public ResponseEntity<String> registerGrocer(@RequestBody GrocerModel model){
		GrocerEntity grocer = grocerService.saveGrocer(model);
		return new ResponseEntity<>("Grocer Registered Successfully. ID : "+grocer.getGrocerID(),HttpStatus.CREATED);

	}

	@PostMapping(value = "/user",
			consumes = "application/json"
			)
	public ResponseEntity<String> registerUser(@RequestBody UserModel model){
		UserEntity user = service.saveUser(model);
		return new ResponseEntity<>("User Registered Successfully. ID : "+user.getUserID(),HttpStatus.CREATED);

	}
}
