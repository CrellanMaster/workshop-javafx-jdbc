package model.dao;

import java.util.List;

public interface EntityDao<T> {

	T findById(Integer id);

	List<T> findAll();

	void updateById(T obj);

	void deleteById(T obj);
}
