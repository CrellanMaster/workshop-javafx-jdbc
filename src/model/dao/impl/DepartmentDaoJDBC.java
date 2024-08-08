package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.exceptions.DbException;
import model.dao.EntityDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements EntityDao<Department> {
	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateById(Department obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Department obj) {
		// TODO Auto-generated method stub

	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department(null, null);
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}
}
