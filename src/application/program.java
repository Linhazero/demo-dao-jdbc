package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.creatSallerDao();
		
		System.out.println("=== test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 3: seller findAll ===");
		 list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new java.util.Date(), 4000.00, department );
		sellerDao.insert(newSeller);
		System.out.println("Insertd! new id = " + newSeller.getId());
		
		System.out.println("\n=== test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completd");
		
		System.out.println("\n=== test 6: seller delete ===");
		System.out.println("Enter id for delete testes");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
