package com.formationkilo.soap.webservice.service;

import java.util.List;

import com.formationkilo.metier.dto.UserDto;
import com.formationkilo.metier.service.IUserService;
import com.formationkilo.metier.service.UserService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class UserWebServiceImpl implements UserWebService {

	//private final IUserService userService = new UserService();
     private final IUserService userService=new UserService();
	@Override
	@WebMethod(operationName = "getProduct")
	public UserDto get(@WebParam(name = "idUser") int id) {
		
		return userService.get(id);
	}

	@Override
	@WebMethod(operationName = "allUsers")
	public List<UserDto> all() {
		
		return userService.getAll();
	}

	@Override
	@WebMethod(operationName = "saveUser")
	public UserDto save(@WebParam(name = "user") UserDto userDto) {

		return userService.save(userDto)? userDto: null;
	}

}