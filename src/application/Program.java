package application;

import java.sql.Date;
import java.util.List;

import model.DAO.SellerDao;
import model.DAO.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
		System.out.println("=== TEST 1: findById =======");
        Seller seller = sellerDao.findById(3); 
        System.out.println(seller);
        
		System.out.println("\n=== TEST 2: findBy Department=======");
        Department department = new Department(1, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list) {
        	System.out.println(obj);
        }
    }
}
