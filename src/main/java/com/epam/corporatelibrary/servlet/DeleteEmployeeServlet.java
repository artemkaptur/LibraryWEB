/**
 * 
 */
package com.epam.corporatelibrary.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.corporatelibrary.dao.EmployeeDAO;
import com.epam.corporatelibrary.dao.impl.EmployeeDaoDBImpl;

/**
 * @author Артем
 *
 */
public class DeleteEmployeeServlet extends HttpServlet {
	private final static String index = "/employeesPage.jsp";

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(index).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF8");

		final String employees_id = req.getParameter("employees_id");

		EmployeeDAO employeeDao = new EmployeeDaoDBImpl();
		employeeDao.delete(Integer.valueOf(employees_id));

		doGet(req, resp);
	}
}
