package model.DAO.impl;

import java.sql.Connection;
import java.util.List;

import model.DAO.SellerDao;
import model.entities.Seller;

public class SellerDAOjdbc implements SellerDao{

	private Connection connection;
	
	public SellerDAOjdbc(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
