/**
 * 
 */
package com.epam.corporatelibrary.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Артем
 *
 */
public class Report {

	private List<EmployeeBook> report;

	public Report() {
		super();
		report = new ArrayList<EmployeeBook>();
	}

	public Report(List<EmployeeBook> report) {
		super();
		this.report = report;
	}

	public List<EmployeeBook> getReport() {
		return report;
	}

	public void setReport(List<EmployeeBook> report) {
		this.report = report;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((report == null) ? 0 : report.hashCode());
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
		Report other = (Report) obj;
		if (report == null) {
			if (other.report != null)
				return false;
		} else if (!report.equals(other.report))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [report=" + report + "]";
	}

}
