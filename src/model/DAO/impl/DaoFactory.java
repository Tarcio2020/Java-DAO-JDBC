package model.DAO.impl;


import db.DbJava;
import model.DAO.SellerDao;

public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new SellerDaoJdbc(DbJava.getConnection());
	}
}
