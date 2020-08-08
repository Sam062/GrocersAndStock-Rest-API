package base.service;

import base.entity.UserEntity;
import base.model.UserModel;

public interface IUserService {

	UserEntity saveUser(UserModel model);
	
	
}
