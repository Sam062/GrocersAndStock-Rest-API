package base.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.GrocerEntity;

public interface IGrocerRepo extends JpaRepository<GrocerEntity, Serializable>{
	
	List<GrocerEntity> findByLocation(String location);
//	List<GrocerEntity> findByItemsForSale(List<String> itemsForSale);
	
	
	
	
//	@Query("FROM GrocerEntity WHERE grocerID=(Select grocerID FROM itemsForSale WHERE ITEMS_LIST:item)")
//	List<GrocerEntity> findByItemForSale(String item);
	
	
}
