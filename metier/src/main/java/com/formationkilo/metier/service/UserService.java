package com.formationkilo.metier.service;

import java.util.List;
import java.util.Optional;

import com.formationkilo.metier.dao.IUserDao;
import com.formationkilo.metier.dao.UserDao;
import com.formationkilo.metier.dto.UserDto;
import com.formationkilo.metier.entity.UserEntity;
import com.formationkilo.metier.mapper.UserMapper;

public class UserService implements IUserService {

	private final IUserDao userDao=new UserDao();
	
	@Override
	public List<UserDto> getAll() {
	
		return UserMapper.listUserEntityToListUserDto(userDao.list(new UserEntity()));
	}

	@Override
	public UserDto get(int id) {
		return UserMapper.toUserDto(userDao.get(id, new UserEntity()));
	}

	@Override
	public boolean delete(int id) {
		return userDao.delete(id, new UserEntity());
	}

	@Override
	public boolean save(UserDto userDto) {
		
		return userDao.save(UserMapper.toUserEtity(userDto));
	}

	@Override
	public boolean update(UserDto userDto) {
		return userDao.update(UserMapper.toUserEtity(userDto));
	}

	@Override
	public Optional<UserDto> login(String email, String password) {
		Optional<UserEntity> userEntity = userDao.login(email, password);
		
		if (userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			return Optional.of(UserMapper.toUserDto(user));
		} else {
			return Optional.empty();
		}
	}
}