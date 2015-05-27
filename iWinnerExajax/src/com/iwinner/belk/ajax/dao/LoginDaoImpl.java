package com.iwinner.belk.ajax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iwinner.belk.ajax.DTO.UserDTO;
import com.iwinner.belk.ajax.utils.BelkAjaxPOCConstatnts;
import com.iwinner.belk.ajax.utils.DaoException;
import com.iwinner.belk.ajax.utils.DbUtils;

public class LoginDaoImpl implements LoginDaoIF{

	public Integer loginVerify(String username, String password)	throws DaoException {
		Integer verifyID = 0;
		try {
			Connection conn = DbUtils.getConnection();
			PreparedStatement ps = conn	.prepareStatement(BelkAjaxPOCConstatnts.LOGIN_QUERY);
			ps.setString(1, username);
			ps.setString(2, password);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				if (id == BelkAjaxPOCConstatnts.ONE_VALUE) {
					verifyID = BelkAjaxPOCConstatnts.USER_FOUND;
				} else if (id != BelkAjaxPOCConstatnts.ONE_VALUE) {
					verifyID = BelkAjaxPOCConstatnts.USER_NOT_FOUND;
				}
			}
		} catch (Exception e) {
			verifyID = BelkAjaxPOCConstatnts.USER_NOT_FOUND;
			throw new DaoException(e.getMessage());

		}
		return verifyID;
	}

	public  UserDTO getUserDetails(String username)throws DaoException{

		UserDTO userDTO=new UserDTO();
		try {
        Connection conn=DbUtils.getConnection();
        PreparedStatement ps = conn	.prepareStatement(BelkAjaxPOCConstatnts.SELECT_QUERY);
        ps.setString(1, username);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        	userDTO.setUserName(rs.getString("USER_NAME"));
        	userDTO.setUserAddress(rs.getString("USER_ADDRESS"));
        	userDTO.setUserComments(rs.getString("USER_COMMENTS"));
        	userDTO.setUserProject(rs.getString("USER_PROJECT"));
        	userDTO.setUserEmail(rs.getString("USER_EMAIL"));
        	userDTO.setUserSal(rs.getFloat("USER_SAL"));
        	userDTO.setUserPhone(rs.getInt("USER_PHONE"));
        	userDTO.setUserTimestamp(rs.getTimestamp("USER_JOIN_TIME"));
        	userDTO.setUserJoinDate(rs.getDate("USER_JOIN_DATE"));
        	userDTO.setUserID(rs.getString("USER_ID"));
        	userDTO.setUserComments(rs.getString("USER_COMMENTS"));
        }
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return userDTO;
	}
	public static void main(String[] args) {
		try{
		LoginDaoImpl ld=new LoginDaoImpl();
		UserDTO userDTO= ld.getUserDetails("anjaiahspr");
			System.out.println(userDTO.toString());	
	}catch(Exception e){
		
	}
}
}
