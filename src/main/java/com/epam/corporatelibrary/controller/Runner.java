/**
 * 
 */
package com.epam.corporatelibrary.controller;

import static com.epam.corporatelibrary.controller.util.InputFromConsole.scanInfo;
import static com.epam.corporatelibrary.controller.util.OutputToConsole.printList;

import java.text.ParseException;
import java.util.List;

import com.epam.corporatelibrary.dao.BookDAO;
import com.epam.corporatelibrary.dao.EmployeeDAO;
import com.epam.corporatelibrary.dao.impl.BookDaoDBImpl;
import com.epam.corporatelibrary.dao.impl.EmployeeDaoDBImpl;
import com.epam.corporatelibrary.domain.Book;
import com.epam.corporatelibrary.domain.Employee;
import com.epam.corporatelibrary.service.LibraryService;
import com.epam.corporatelibrary.service.impl.CorporateLibraryServiceImpl;

/**
 * @author Артем
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		BookDAO daoBook = new BookDaoDBImpl();
		List<Book> allBooks = daoBook.readAll();
		List<Book> booksByTitle = daoBook.readByTitle(scanInfo());

		printList(allBooks);
		printList(booksByTitle);

		Book book = new Book(35, "War and piece", "History", 1999, "Tolstoy");
		daoBook.create(book);
		allBooks = daoBook.readAll();
		printList(allBooks);

		daoBook.delete(35);
		allBooks = daoBook.readAll();
		printList(allBooks);

		EmployeeDAO daoEmployee = new EmployeeDaoDBImpl();
		List<Employee> allEmployees = daoEmployee.readAll();
		List<Employee> employeesBySurame = daoEmployee.readByEmail(scanInfo());

		printList(allEmployees);
		printList(employeesBySurame);

		// SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MM");
		// java.sql.Date date1 = (java.sql.Date) df.parse("2006-06-06");
		@SuppressWarnings("deprecation")
		java.sql.Date date1 = new java.sql.Date(2006, 6, 6);

		Employee employee = new Employee(11, "Bill", "Turner", date1, "Turner@gmail.com");
		daoEmployee.create(employee);
		allEmployees = daoEmployee.readAll();
		printList(allEmployees);

		daoEmployee.delete(11);
		allEmployees = daoEmployee.readAll();
		printList(allEmployees);

		LibraryService service = new CorporateLibraryServiceImpl();
		printList(service.getReport(2, 5).getReport());

	}

}
