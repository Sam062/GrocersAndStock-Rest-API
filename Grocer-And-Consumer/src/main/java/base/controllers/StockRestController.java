package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.exceptions.DataReadingException;
import base.responces.ResponseModel;
import base.service.IGrocerService;

@RestController
@RequestMapping("/stocklist")
public class StockRestController {
	//	@Autowired
	//	private IUserService userService;
	@Autowired
	private IGrocerService grocerService;

	@GetMapping(value = "/location/{location}")
	public ResponseEntity<ResponseModel> getStockByLocation(@PathVariable("location")String location){
		try {
			ResponseModel grocerList = grocerService.findByLocation(location);

			if(grocerList!=null)
				return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.OK);
			else
				return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new DataReadingException();
		}
	}

	@GetMapping("/item/{item}")
	public ResponseEntity<ResponseModel> getGrocersByItem(@PathVariable("item")String item){
		ResponseModel grocerList = grocerService.findByItemForSale(item);
		if(grocerList!=null)
			return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.OK);
		else
			return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.NO_CONTENT);
	}


}
