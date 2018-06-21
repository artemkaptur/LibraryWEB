package com.epam.corporatelibrary.dao;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.epam.corporatelibrary.dao.impl.BookDaoDBImpl;
import com.epam.corporatelibrary.dao.impl.util.DBConnectionHelper;
import com.epam.corporatelibrary.domain.Book;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BookDAOImplTest {
	private Connection connection;
	private BookDAO bookDao;
	private Statement st;
	private List<Book> expectedList;
	private final Logger logger = LogManager.getRootLogger();

	@Test
	public void createdCorrectBookTest() throws SQLException {
		Book book = new Book(36, "Run baby run", "Adventure", 2017, "Biber");
		int previousCount = findCurrentBookCount(book.getTitle());
		bookDao.create(book);
		int currentCount = findCurrentBookCount(book.getTitle());
		assertTrue(previousCount == currentCount - 1, "The book wasn't inserted in DB");
	}

	@Test
	public void deletedCorrectBookTest() throws SQLException {
		int previousCount = findCurrentBookCount("Run baby run");
		bookDao.delete(36);
		int currentCount = findCurrentBookCount("Run baby run");
		assertTrue(previousCount == currentCount + 1, "The book wasn't deleted in DB");
	}

	@Test
	public void readCorrectBookByIdTest() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM book WHERE ID = 1");
		expectedList = fillList(rs);
		List<Book> actualList = new ArrayList<Book>();
		actualList.add(bookDao.read(1));
		assertEquals(actualList, expectedList, "The recieved book is not equal real book in DB");
	}

	@Test
	public void readAllCorrectBooksTest() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM book");
		expectedList = fillList(rs);
		List<Book> actualList = bookDao.readAll();
		assertEquals(actualList, expectedList, "The recieved books are not equal real books in DB");
	}

	@Test
	public void receviedEmptyListTest() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM book WHERE title = 'blablablablabla'");
		List<Book> expectedList = new ArrayList<>();
		while (rs.next()) {
			expectedList.add(new Book());
		}
		List<Book> actualList = bookDao.readByTitle("blablablablabla");
		assertEquals(actualList, expectedList, "The recieved list is not empty");
	}

	@Test
	public void readByTitleCorrectBookTest() throws SQLException {
		ResultSet rs = st.executeQuery("SELECT * FROM book WHERE title = 'BookOne'");
		expectedList = fillList(rs);
		List<Book> actualList = bookDao.readByTitle("BookOne");
		assertEquals(actualList, expectedList, "The recieved book is not equal real book in DB");
	}

	private int findCurrentBookCount(String title) throws SQLException {
		int currentCount = 0;
		ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM book WHERE Title = " + "'" + title + "'");
		while (rs.next()) {
			currentCount = rs.getInt("COUNT(id)");
		}
		return currentCount;
	}

	private List<Book> fillList(ResultSet rs) throws SQLException {
		while (rs.next()) {
			Book book = new Book();
			book.setId(rs.getInt("ID"));
			book.setTitle(rs.getString("Title"));
			book.setBrief(rs.getString("Brief"));
			book.setPublishYear(rs.getInt("Publish_year"));
			book.setAuthor(rs.getString("Author"));
			expectedList.add(book);
		}
		return expectedList;
	}

	@BeforeClass
	public void initDBConnection() throws SQLException {
		connection = DBConnectionHelper.connect();
		st = connection.createStatement();
		logger.info("Connected to DB");
	}

	@AfterClass
	public void closeDBConnection() {
		DBConnectionHelper.disconnect(connection);
		logger.info("Disconnect from DB");
	}

	@BeforeMethod
	public void ititDao() {
		bookDao = new BookDaoDBImpl();
		expectedList = new ArrayList<>();
		logger.info("BookDao was initialized");
	}

	@AfterMethod
	public void freeMemory() {
		bookDao = null;
		expectedList = null;
		logger.info("ExpectedList and bookDao are null values");
	}

}
