package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import commons.Controller;

public class AddFormController implements Controller {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		request.setAttribute("cp", "add");
		return "manager/addform.jsp";
	}

}
