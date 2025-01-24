package application;


import java.sql.Date;

import model.DAO.SellerDAO;
import model.DAO.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(2, "rh");
	
	
		Seller obj2 = new Seller(1, "Tarcio", "tarcio@example.com", Date.valueOf("2024-01-01"), 3000.0);

		SellerDAO sellerDAO = DaoFactory.createSellerDao();
		
		
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(sellerDAO);


	}

}
