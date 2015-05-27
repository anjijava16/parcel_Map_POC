package com.iwinner.belk.ajax.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iwinner.belk.ajax.DTO.UserDTO;
import com.iwinner.belk.ajax.dao.LoginDaoIF;
import com.iwinner.belk.ajax.utils.BelkAjaxPOCConstatnts;
import com.iwinner.belk.ajax.utils.DaoException;
import com.iwinner.belk.ajax.utils.DaoFactory;
import com.iwinner.belk.ajax.vo.UserVO;

/**
 * Servlet implementation class LoginServlet
 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDaoIF loginDaoIF=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestName = request.getRequestURI();
		String uri = requestName.substring(requestName.lastIndexOf("/") + 1,	requestName.length());
		System.out.println("URI INFO "+uri);
			if(BelkAjaxPOCConstatnts.LOGIN_ACTION_URL.equals(uri)){
				doLoginExecute(request,response);
			} else if(BelkAjaxPOCConstatnts.CUSTOMER_URL.equals(uri)){
				customerDetailsAction(request,response);
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestName = request.getRequestURI();
		String uri = requestName.substring(requestName.lastIndexOf("/") + 1,	requestName.length());
		System.out.println("URI INFO "+uri);
			if(BelkAjaxPOCConstatnts.LOGIN_ACTION_URL.equals(uri)){
				doLoginExecute(request,response);
			} else if(BelkAjaxPOCConstatnts.CUSTOMER_URL.equals(uri)){
				customerDetailsAction(request,response);
			}
    }
    public void doLoginExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer verifyLoginId=0;
    
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username==null || password==null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}else{
		try {
			loginDaoIF=DaoFactory.loginDaoFactory();
			verifyLoginId=loginDaoIF.loginVerify(username, password);
			if(verifyLoginId==BelkAjaxPOCConstatnts.USER_FOUND){
				request.getRequestDispatcher("/WEB-INF/jsp/homePage.jsp").forward(request, response);
			}else if(verifyLoginId!=BelkAjaxPOCConstatnts.USER_NOT_FOUND){
				request.setAttribute("message", BelkAjaxPOCConstatnts.INVALID_CREDS);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				
				request.setAttribute("message", BelkAjaxPOCConstatnts.CONNECTION_ISSUE_ERROR);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
    }
    public void customerDetailsAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        System.out.println("Username is :::>>>>>"+username);
        JsonObject myObj = new JsonObject();        if(username==null){
    		response.getWriter().write(BelkAjaxPOCConstatnts.USER_NOT_FOUND_MESSAGE);
    		myObj.addProperty("success", false);
        	return ;
        }else if(username!=null){
			loginDaoIF=DaoFactory.loginDaoFactory();
			try {
				UserDTO userDTO=loginDaoIF.getUserDetails(username);
				if(userDTO.getUserName()==null){
					request.setAttribute("returnMessage", BelkAjaxPOCConstatnts.USER_NOT_FOUND_MESSAGE);
					response.getWriter().write(BelkAjaxPOCConstatnts.USER_NOT_FOUND_MESSAGE);
					myObj.addProperty("success", false);
					return ;
				}
				UserVO userVO=new UserVO();
				try {
					BeanUtils.copyProperties(userVO, userDTO);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				
				if(userVO.getUserName()!=null){
					Gson gson = new Gson(); 
			        JsonElement countryObj = gson.toJsonTree(userVO);
			        myObj.addProperty("success", true);
			        myObj.add("countryInfo", countryObj);
			        response.getWriter().write(myObj.toString());
					//response.getWriter().write(BelkAjaxPOCConstatnts.USER_FOUND_MESSAGE);
					return;
				}
			} catch (DaoException e) {
				e.printStackTrace();
			}
        }
    }
  
    public void updateInfoCustomerAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
}