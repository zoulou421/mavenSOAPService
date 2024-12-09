package com.formationkilo.metier.dao;

import java.util.Optional;

import com.formationkilo.metier.entity.UserEntity;

public interface IUserDao extends Repository<UserEntity> {

	public Optional<UserEntity> login (String email, String password);
}