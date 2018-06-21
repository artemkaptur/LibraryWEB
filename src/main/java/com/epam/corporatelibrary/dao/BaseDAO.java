/**
 * 
 */
package com.epam.corporatelibrary.dao;

import java.util.List;

import com.epam.corporatelibrary.domain.Entity;

/**
 * @author Артем
 *
 */
public interface BaseDAO<T extends Entity> {

	public void create(T entity);

	public void delete(int id);

	public T read(int id);

	public List<T> readAll();

	public void update(int id, T entity);

}
