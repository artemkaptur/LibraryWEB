/**
 * 
 */
package com.epam.corporatelibrary.servlet;

import java.io.IOException;
import java.sql.Date;

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
public class UpdateEmployeeServlet extends HttpServlet {
	private final static String index = "/employeesPage.jsp";

	private Employee employee;

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
		final String name = req.getParameter("name");
		final String surname = req.getParameter("surname");
		final String birth_date = req.getParameter("publish_year");
		final String email = req.getParameter("email");

		employee = new Employee(1, name, surname, new Date(2006, 6, 6), email);
		EmployeeDAO employeeDao = new EmployeeDaoDBImpl();
		employeeDao.update(Integer.valueOf(employees_id), employee);

		doGet(req, resp);
	}
}
