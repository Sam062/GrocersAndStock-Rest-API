package base.service;

import base.entity.GrocerEntity;
import base.model.GrocerModel;
import base.responces.ResponseModel;

public interface IGrocerService {
	GrocerEntity saveGrocer(GrocerModel model);
	ResponseModel findByLocation(String loc);
	
	ResponseModel findByItemForSale(String item);

}
