package base.controllers;

import java.util.List;

import base.model.GrocerModel;
import lombok.Data;

@Data
public class ResponseByItem {
	private List<GrocerModel> listOfGrocerModel;

}
