/**
 * 
 */
package com.epam.corporatelibrary.servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.corporatelibrary.dao.EmployeeDAO;
import com.epam.corporatelibrary.dao.impl.EmployeeDaoDBImpl;
import com.epam.corporatelibrary.domain.Employee;

/**
 * @author Артем
 *
 */
public class ShowAllEmployeesServlet extends HttpServlet {
	private final static String index = "/employeesPage.jsp";

	private List<Employee> employees;

	@Override
	public void init() throws ServletException {
		employees = new CopyOnWriteArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("employees", employees);
		req.getRequestDispatcher(index).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF8");

		EmployeeDAO employeeDao = new EmployeeDaoDBImpl();
		employees = employeeDao.readAll();

		doGet(req, resp);
	}
}
