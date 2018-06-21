/**
 * 
 */
package com.epam.corporatelibrary.dao;

import java.util.List;

import com.epam.corporatelibrary.domain.Book;

/**
 * @author Артем
 *
 */
public interface BookDAO extends BaseDAO<Book> {

	public List<Book> readByTitle(String title);
}
