package base.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.entity.GrocerEntity;
import base.exceptions.DataReadingException;
import base.model.GrocerModel;
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

			if(grocerList!=null && (!grocerList.getListOfGrocers().isEmpty()))
				return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.OK);
			else
				return new ResponseEntity<ResponseModel>(grocerList,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new DataReadingException();
		}
	}

	@GetMapping("/item/{item}")
	public ResponseEntity<List<GrocerModel>> getGrocersByItem(@PathVariable("item")String item){
		List<GrocerModel> findAll = grocerService.findAll();
		List<GrocerModel> grocerModel = findAll.stream().filter(g->g.getItemsForSale().contains(item)).collect(Collectors.toList());

		if(!grocerModel.isEmpty())
			return new ResponseEntity<List<GrocerModel>>(grocerModel,HttpStatus.ACCEPTED);
		else
			throw new DataReadingException();
	}


}
