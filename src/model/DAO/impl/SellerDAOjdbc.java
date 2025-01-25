package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DbException;
import db.DbJava;
import model.DAO.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJdbc implements SellerDao {

	private Connection conn;

	public SellerDaoJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null;
		
		try {
		    st = conn.prepareStatement(
		        "INSERT INTO seller " +
		        "(Name, Email, BirthDate, BaseSalary, DepartmentId) " + 
		        "VALUES "  + 
		        "(?, ?, ?, ?, ?)",
		        java.sql.Statement.RETURN_GENERATED_KEYS
		    );
		    
		    st.setString(1, obj.getName());      
		    st.setString(2, obj.getEmail());     
		    st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
		    st.setDouble(4, obj.getBaseSalary());                  
		    st.setInt(5, obj.getDepartment().getId());                          
		    
		    int rowsAffected = st.executeUpdate();
		    System.out.println("Rows affected: " + rowsAffected);
		    
		    if (rowsAffected > 0) {
		    	ResultSet rs = st.getGeneratedKeys();
		    	if(rs.next()) {
		    		int id = rs.getInt(1);
		    		obj.setId(id);
		    	}
		    }
		    else {
		    	throw new DbException("Unexpected error! No rows affected");
		    }
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DbJava.closeStatement(st);
		}

	}

	@Override
	public void update(Seller obj) {
		PreparedStatement st = null;
		
		try {
		    st = conn.prepareStatement(
		    		"UPDATE seller " +
		    		"SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
		    		"WHERE Id = ?"		    );
		    
		    st.setString(1, obj.getName());      
		    st.setString(2, obj.getEmail());     
		    st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
		    st.setDouble(4, obj.getBaseSalary());                  
		    st.setInt(5, obj.getDepartment().getId());                          
		    st.setInt(6, obj.getId()); 
		    
		    st.executeUpdate();
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DbJava.closeStatement(st);
		}	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Seller findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName " + 
							"FROM seller INNER JOIN department " +
							"ON seller.DepartmentId = department.Id " +
							"WHERE seller.Id = ?"
					);

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dp = instatiateDepartment(rs);

				Seller obj = instatiateSeller(rs, dp);
				return obj; 
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbJava.closeStatement(st);
			DbJava.closeResultSet(rs);
		}
	}

	private Seller instatiateSeller(ResultSet rs, Department dp) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dp);
		return obj;
	}

	private Department instatiateDepartment(ResultSet rs) throws SQLException {
		Department dp = new Department();
		dp.setId(rs.getInt("DepartmentId"));
		dp.setName(rs.getString("DepName"));		
		return dp;
	}

	@Override
	public List<Seller> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName " +
							"FROM seller INNER JOIN department " +
							"ON seller.DepartmentId = department.Id " +
							"ORDER BY Name"
					);

			rs = st.executeQuery();

			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			while (rs.next()) {
				Department dp = map.get(rs.getInt("DepartmentId"));

				if (dp == null) {
					dp = instatiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dp);
				}

				Seller obj = instatiateSeller(rs, dp);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbJava.closeStatement(st);
			DbJava.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName " +
							"FROM seller INNER JOIN department " +
							"ON seller.DepartmentId = department.Id " +
							"WHERE DepartmentId = ? " +
							"ORDER BY Name"
					);

			st.setInt(1, department.getId());
			rs = st.executeQuery();

			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();

			while (rs.next()) {
				Department dp = map.get(rs.getInt("DepartmentId"));

				if (dp == null) {
					dp = instatiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dp);
				}

				Seller obj = instatiateSeller(rs, dp);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DbJava.closeStatement(st);
			DbJava.closeResultSet(rs);
		}
	}
}
