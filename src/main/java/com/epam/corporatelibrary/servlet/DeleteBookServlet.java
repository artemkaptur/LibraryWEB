/**
 * 
 */
package com.epam.corporatelibrary.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.corporatelibrary.dao.BookDAO;
import com.epam.corporatelibrary.dao.impl.BookDaoDBImpl;
import com.epam.corporatelibrary.domain.Book;

/**
 * @author Артем
 *
 */
public class DeleteBookServlet extends HttpServlet {
	private final static String index = "/booksPage.jsp";

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

		final String books_id = req.getParameter("books_id");

		BookDAO bookDao = new BookDaoDBImpl();
		bookDao.delete(Integer.valueOf(books_id));

		doGet(req, resp);
	}
}
