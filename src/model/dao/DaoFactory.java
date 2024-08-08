package model.dao;

import model.dao.impl.DepartmentDaoJDBC;

public class DaoFactory {
	public static DepartmentDaoJDBC createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}
}
