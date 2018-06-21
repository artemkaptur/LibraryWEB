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
public class CreateBookServlet extends HttpServlet {

	private final static String index = "/booksPage.jsp";

	private Book book;

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

		final String title = req.getParameter("title");
		final String brief = req.getParameter("brief");
		final String publish_year = req.getParameter("publish_year");
		final String author = req.getParameter("author");

		book = new Book(1, title, brief, Integer.valueOf(publish_year), author);
		BookDAO bookDao = new BookDaoDBImpl();
		bookDao.create(book);

		doGet(req, resp);
	}
}
