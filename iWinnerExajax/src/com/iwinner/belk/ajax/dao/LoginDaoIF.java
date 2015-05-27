package com.iwinner.belk.ajax.dao;

import com.iwinner.belk.ajax.DTO.UserDTO;
import com.iwinner.belk.ajax.utils.DaoException;

public interface LoginDaoIF {

	public Integer loginVerify(String username,String password)throws DaoException;
	public UserDTO getUserDetails(String username)throws DaoException;
}
