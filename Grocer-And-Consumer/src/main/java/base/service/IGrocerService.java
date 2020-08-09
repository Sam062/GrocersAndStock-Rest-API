package base.service;

import java.util.List;

import base.entity.GrocerEntity;
import base.model.GrocerModel;
import base.responces.ResponseModel;

public interface IGrocerService {
	GrocerEntity saveGrocer(GrocerModel model);
	ResponseModel findByLocation(String loc);

	List<GrocerModel> findAll();

}
