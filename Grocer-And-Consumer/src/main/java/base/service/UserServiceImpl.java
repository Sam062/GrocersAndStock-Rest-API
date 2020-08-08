package base.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.UserEntity;
import base.exceptions.DataNotRegisteredException;
import base.model.UserModel;
import base.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;

	@Override
	public UserEntity saveUser(UserModel model) {
		try {
			UserEntity entity=new UserEntity();
			BeanUtils.copyProperties(model, entity);
			return repo.save(entity);
		} catch (Exception e) {
			throw new DataNotRegisteredException();
		}
	}
}
