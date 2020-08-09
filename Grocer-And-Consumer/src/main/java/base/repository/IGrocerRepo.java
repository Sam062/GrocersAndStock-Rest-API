package base.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.GrocerEntity;

public interface IGrocerRepo extends JpaRepository<GrocerEntity, Serializable>{

	List<GrocerEntity> findByLocation(String location);
	List<GrocerEntity> findAll();
}
