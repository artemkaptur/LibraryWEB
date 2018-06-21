package com.epam.corporatelibrary.service;

import com.epam.corporatelibrary.domain.Report;

public interface LibraryService {

	Report getReport(int moreThen, int lessThen);

}
