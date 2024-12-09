package com.formationkilo.soap.webservice.service;

import java.util.List;

import com.formationkilo.metier.dto.UserDto;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface UserWebService {

	@WebMethod(operationName = "getUser")
	UserDto get(@WebParam(name = "idUser") int id);
	
	@WebMethod(operationName = "allUsers")
	List<UserDto> all();
	
	@WebMethod(operationName = "saveUser")
	UserDto save(@WebParam(name = "user") UserDto userDto);
}
