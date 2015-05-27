package com.iwinner.belk.ajax.utils;

public class BelkAjaxPOCConstatnts {
//SELECT COUNT(*) FROM USERS WHERE NAME=? AND PASSWORD=?
public static String LOGIN_QUERY="SELECT COUNT(*) FROM USERS us WHERE us.USERNAME=? AND us.PASSWORD=?";
public static String SELECT_QUERY="SELECT * FROM user_personal us WHERE us.USER_NAME=?";
public static Integer USER_FOUND=1000;
public static Integer USER_NOT_FOUND=1001;
public static Integer USER_FOUND_ERROR=1002;
public static Integer ONE_VALUE=1;
public static Integer ZERO_VALUE=1;
public static String INVALID_CREDS="Please enter valid creds";
public static String CONNECTION_ISSUE_ERROR="Connection failed ,please contact system admin";


public static String LOGIN_ACTION_URL="loginVerification.action";
public static String CUSTOMER_URL="customerDetails.action";
public static String CUSTOMER_URL_SAVING="updateCustomerDetails.action";

public static String USER_NOT_FOUND_MESSAGE="User not found";
public static String USER_FOUND_MESSAGE="User Found";

}
