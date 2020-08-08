package base.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.GrocerEntity;
import base.model.GrocerModel;
import base.repository.IGrocerRepo;
import base.responces.ResponseModel;

@Service
public class GrocerServiceImpl implements IGrocerService {
	@Autowired
	private IGrocerRepo repo;

	@Override
	public GrocerEntity saveGrocer(GrocerModel model) {
		GrocerEntity entity=new GrocerEntity();
		BeanUtils.copyProperties(model, entity);
		return repo.save(entity);
	}

	@Override
	public ResponseModel findByLocation(String loc) {
		List<GrocerEntity> grocerEntity = repo.findByLocation(loc);
		List<GrocerModel> listOfGrocerModel = grocerEntity.stream().map(g->{
			GrocerModel grocerModel = new GrocerModel();
			BeanUtils.copyProperties(g, grocerModel);
			return grocerModel;
		}).collect(Collectors.toList());

		ResponseModel listOfGrocers = new ResponseModel();
		listOfGrocers.setListOfGrocers(listOfGrocerModel);

		return listOfGrocers;
	}
	@Override
	public ResponseModel findByItemForSale(String item) {
//		List<GrocerEntity> grocerEntity = repo.findByItemForSale(item);
//		
//		List<GrocerModel> listOfGrocerModel = grocerEntity.stream().map(g->{
//			GrocerModel grocerModel = new GrocerModel();
//			BeanUtils.copyProperties(g, grocerModel);
//			return grocerModel;
//		}).collect(Collectors.toList());
//
//		ResponseModel listOfGrocers = new ResponseModel();
//		listOfGrocers.setListOfGrocers(listOfGrocerModel);
//
//		return listOfGrocers;
		return null;
	}
	
}
