/**
 * 
 */
package com.epam.corporatelibrary.service.impl;

import static com.epam.corporatelibrary.dao.impl.util.DBConnectionHelper.connect;
import static com.epam.corporatelibrary.dao.impl.util.DBConnectionHelper.disconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.corporatelibrary.domain.EmployeeBook;
import com.epam.corporatelibrary.domain.Report;
import com.epam.corporatelibrary.service.LibraryService;

/**
 * @author Артем
 *
 */
public class CorporateLibraryServiceImpl implements LibraryService {

	private static final String SQL_SELECT_EMPLOYEE_BOOK = "SELECT (SELECT Name FROM employee WHERE ID = EMPLOYEE_ID) AS Name, "
			+ "(SELECT Date_of_birth FROM employee WHERE ID = EMPLOYEE_ID) AS Date_of_birth, "
			+ "COUNT(BOOK_ID) AS Book_count FROM employee_book GROUP BY EMPLOYEE_ID HAVING count(BOOK_ID) > ";

	@Override
	public Report getReport(int moreThen, int lessThen) {
		Connection connection = connect();
		Report report = new Report();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEE_BOOK + moreThen + " AND count(BOOK_ID) < " + lessThen);
			while (rs.next()) {
				EmployeeBook emploeebook = new EmployeeBook();
				emploeebook.setEmployeeName(rs.getString("Name"));
				emploeebook.setEmployeeDateOfBirth(rs.getDate("Date_of_birth"));
				emploeebook.setBookCount(rs.getInt("Book_count"));

				report.getReport().add(emploeebook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return report;
	}

}
