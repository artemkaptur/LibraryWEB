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

import com.epam.corporatelibrary.dao.EmployeeDAO;
import com.epam.corporatelibrary.domain.Employee;

/**
 * @author Артем
 *
 */
public class EmployeeDaoDBImpl implements EmployeeDAO {

	private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee (Name, Surname, Date_of_birth, Email) VALUES";
	private static final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE ID = ";
	private static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE ID = ";
	private static final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
	private static final String SQL_SELECT_EMPLOYEES_BY_EMAIL = "SELECT * FROM employee WHERE Email = ";
	private static final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET ";

	public void create(Employee employee) {
		Connection connection = connect();
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_INSERT_EMPLOYEE + " ('" + employee.getName() + "', '" + employee.getSurname() + "', '"
					+ employee.getDateOfBirth() + "', '" + employee.getEmail() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

	public void delete(int id) {
		Connection connection = connect();
		try {

			Statement st = connection.createStatement();
			st.executeUpdate(SQL_DELETE_EMPLOYEE + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

	public Employee read(int id) {
		Connection connection = connect();
		Employee employee = new Employee();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEE_BY_ID + "'" + id + "'");

			while (rs.next()) {
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("Name"));
				employee.setSurname(rs.getString("Surname"));
				employee.setDateOfBirth(rs.getDate("Date_of_birth"));
				employee.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return employee;
	}

	public List<Employee> readAll() {
		List<Employee> employees = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_EMPLOYEES);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("Name"));
				employee.setSurname(rs.getString("Surname"));
				employee.setDateOfBirth(rs.getDate("Date_of_birth"));
				employee.setEmail(rs.getString("Email"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return employees;
	}

	public List<Employee> readByEmail(String email) {
		List<Employee> employees = new ArrayList<>();
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEES_BY_EMAIL + "'" + email + "'");

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("Name"));
				employee.setSurname(rs.getString("Surname"));
				employee.setDateOfBirth(rs.getDate("Date_of_birth"));
				employee.setEmail(rs.getString("Email"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
		return employees;
	}

	public void update(int id, Employee entity) {
		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_UPDATE_EMPLOYEE + "ID = '" + id + "', Name = '" + entity.getName() + "', Surname = '"
					+ entity.getSurname() + "', Date_of_birth = '" + entity.getDateOfBirth() + "', Email = '"
					+ entity.getEmail() + "' where ID = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

}
