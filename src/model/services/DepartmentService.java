package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.EntityDao;
import model.entities.Department;

public class DepartmentService {

	private EntityDao<Department> dao = DaoFactory.createDepartmentDao();

	public List<Department> findAll() {
		return dao.findAll();
	}

	public Department findById(Integer id) {
		return dao.findById(id);
	}
}
