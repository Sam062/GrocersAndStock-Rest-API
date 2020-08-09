package base.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.GrocerEntity;
import base.exceptions.DataNotRegisteredException;
import base.exceptions.DataReadingException;
import base.model.GrocerModel;
import base.repository.IGrocerRepo;
import base.responces.ResponseModel;

@Service
public class GrocerServiceImpl implements IGrocerService {
	@Autowired
	private IGrocerRepo repo;

	@Override
	public GrocerEntity saveGrocer(GrocerModel model) {
		try {
			GrocerEntity entity=new GrocerEntity();
			BeanUtils.copyProperties(model, entity);
			return repo.save(entity);
		} catch (Exception e) {
			throw new DataNotRegisteredException();
		}
	}

	@Override
	public ResponseModel findByLocation(String loc) {
		try {
			List<GrocerEntity> grocerEntity = repo.findByLocation(loc);
			List<GrocerModel> listOfGrocerModel = grocerEntity.stream().map(g->{
				GrocerModel grocerModel = new GrocerModel();
				BeanUtils.copyProperties(g, grocerModel);
				return grocerModel;
			}).collect(Collectors.toList());

			ResponseModel listOfGrocers = new ResponseModel();
			listOfGrocers.setListOfGrocers(listOfGrocerModel);

			return listOfGrocers;
		} catch (Exception e) {
			throw new DataReadingException();
		}
	}
//	@Override
//	public List<GrocerEntity> findByItemForSale(String itemsForSale) {
//		return repo.findByItemsForSale(List.of(itemsForSale));
//	}

}
