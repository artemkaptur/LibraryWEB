/**
 * 
 */
package com.epam.corporatelibrary.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.corporatelibrary.domain.EmployeeBook;
import com.epam.corporatelibrary.service.LibraryService;
import com.epam.corporatelibrary.service.impl.CorporateLibraryServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Артем
 *
 */
public class GetIndexPageServlet extends HttpServlet {

	private final static String index = "/searchResultsPage.jsp";

	private List<EmployeeBook> employeeBooks;

	@Override
	public void init() throws ServletException {
		employeeBooks = new CopyOnWriteArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("employeeBooks", employeeBooks);
		req.getRequestDispatcher(index).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF8");

		final String low_border = req.getParameter("low_border");
		final String hight_border = req.getParameter("hight_border");

		LibraryService service = new CorporateLibraryServiceImpl();
		employeeBooks = service.getReport(Integer.valueOf(low_border), Integer.valueOf(hight_border)).getReport();

		doGet(req, resp);
	}
}
