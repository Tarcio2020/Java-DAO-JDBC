package model.DAO.impl;


import model.DAO.SellerDao;

public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new SellerDaoJdbc();
	}
}
