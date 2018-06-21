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

import com.epam.corporatelibrary.dao.BookDAO;
import com.epam.corporatelibrary.dao.impl.BookDaoDBImpl;
import com.epam.corporatelibrary.domain.Book;

/**
 * @author Артем
 *
 */
public class SearchByTitleServlet extends HttpServlet {
	private final static String index = "/booksPage.jsp";

	private List<Book> books;

	@Override
	public void init() throws ServletException {
		books = new CopyOnWriteArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("books", books);
		req.getRequestDispatcher(index).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF8");

		final String title = req.getParameter("title");

		BookDAO bookDao = new BookDaoDBImpl();
		books = bookDao.readByTitle(title);

		doGet(req, resp);
	}
}
