package application;


import java.sql.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(2, "rh");
	
	
		Seller obj2 = new Seller(1, "Tarcio", "tarcio@example.com", Date.valueOf("2024-01-01"), 3000.0);

		System.out.println(obj);
		System.out.println(obj2);

	}

}
