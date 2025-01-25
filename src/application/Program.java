package application;

import java.sql.Date;

import model.DAO.SellerDao;
import model.DAO.impl.DaoFactory;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        Seller seller = sellerDao.findById(3); 

        System.out.println(seller);
    }
}
