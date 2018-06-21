/**
 * 
 */
package com.epam.corporatelibrary.domain;

import java.util.Date;

/**
 * @author Артем
 *
 */
public class EmployeeBook {

	private String employeeName;
	private Date employeeDateOfBirth;
	private int bookCount;

	public EmployeeBook() {
		super();
	}

	public EmployeeBook(String employeeName, Date employeeDateOfBirth, int bookCount) {
		super();
		this.employeeName = employeeName;
		this.employeeDateOfBirth = employeeDateOfBirth;
		this.bookCount = bookCount;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}

	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCount;
		result = prime * result + ((employeeDateOfBirth == null) ? 0 : employeeDateOfBirth.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeBook other = (EmployeeBook) obj;
		if (bookCount != other.bookCount)
			return false;
		if (employeeDateOfBirth == null) {
			if (other.employeeDateOfBirth != null)
				return false;
		} else if (!employeeDateOfBirth.equals(other.employeeDateOfBirth))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeBook [employeeName=" + employeeName + ", employeeDateOfBirth=" + employeeDateOfBirth
				+ ", bookCount=" + bookCount + "]";
	}

}
