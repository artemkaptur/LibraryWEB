/**
 * 
 */
package com.epam.corporatelibrary.dao;

import java.util.List;

import com.epam.corporatelibrary.domain.Employee;

/**
 * @author Артем
 *
 */
public interface EmployeeDAO extends BaseDAO<Employee> {

	public List<Employee> readByEmail(String email);
}
