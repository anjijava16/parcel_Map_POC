package com.iwinner.belk.ajax.utils;

import com.iwinner.belk.ajax.dao.LoginDaoIF;
import com.iwinner.belk.ajax.dao.LoginDaoImpl;

public class DaoFactory {

	private static LoginDaoIF loginDaoIF = null;
	static {
		loginDaoIF=new LoginDaoImpl();
	}
	public static LoginDaoIF loginDaoFactory(){
		return loginDaoIF;
	}
}
