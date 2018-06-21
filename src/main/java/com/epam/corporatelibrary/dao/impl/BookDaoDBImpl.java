/**
 * 
 */
package com.epam.corporatelibrary.dao.impl;

import static com.epam.corporatelibrary.dao.impl.util.DBConnectionHelper.connect;
import static com.epam.corporatelibrary.dao.impl.util.DBConnectionHelper.disconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.corporatelibrary.dao.BookDAO;
import com.epam.corporatelibrary.domain.Book;

/**
 * @author Артем
 *
 */
public class BookDaoDBImpl implements BookDAO {

	private static final String SQL_INSERT_BOOK = "INSERT INTO book (Title, Brief, Publish_year, Author) VALUES";
	private static final String SQL_DELETE_BOOK = "DELETE FROM book WHERE ID = ";
	private static final String SQL_SELECT_BOOK_BY_ID = "SELECT * FROM book WHERE ID = ";
	private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM book";
	private static final String SQL_SELECT_BOOKS_BY_TITLE = "SELECT * FROM book WHERE Title = ";
	private static final String SQL_UPDATE_BOOK = "UPDATE book SET ";

	public void create(Book book) {
		Connection connection = connect();
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_INSERT_BOOK + " ('" + book.getTitle() + "', '" + book.getBrief() + "', '"
					+ book.getPublishYear() + "', '" + book.getAuthor() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

	public void delete(int id) {
		Connection connection = connect();
		try {

			Statement st = connection.createStatement();
			st.executeUpdate(SQL_DELETE_BOOK + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

	public Book read(int id) {
		Connection connection = connect();
		Book book = new Book();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOK_BY_ID + "'" + id + "'");

			while (rs.next()) {
				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("Title"));
				book.setBrief(rs.getString("Brief"));
				book.setPublishYear(rs.getInt("Publish_year"));
				book.setAuthor(rs.getString("Author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return book;
	}

	public List<Book> readAll() {
		List<Book> books = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_BOOKS);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("Title"));
				book.setBrief(rs.getString("Brief"));
				book.setPublishYear(rs.getInt("Publish_year"));
				book.setAuthor(rs.getString("Author"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return books;
	}

	public List<Book> readByTitle(String title) {
		List<Book> books = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS_BY_TITLE + "'" + title + "'");

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("Title"));
				book.setBrief(rs.getString("Brief"));
				book.setPublishYear(rs.getInt("Publish_year"));
				book.setAuthor(rs.getString("author"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return books;
	}

	public void update(int id, Book entity) {
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_UPDATE_BOOK + "ID = '" + id + "', Title = '" + entity.getTitle() + "', Brief = '"
					+ entity.getBrief() + "', Publish_year = '" + entity.getPublishYear() + "', Author = '"
					+ entity.getAuthor() + "' where ID = '" + id + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

}
