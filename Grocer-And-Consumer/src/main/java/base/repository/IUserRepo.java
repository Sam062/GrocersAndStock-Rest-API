package base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entity.UserEntity;

public interface IUserRepo extends JpaRepository<UserEntity, Serializable> {
}
