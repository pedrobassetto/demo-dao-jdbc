package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Teste 1: seller findById ===");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n=== Teste 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Teste 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Teste 4: seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 40000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido: Novo Id: "+ newSeller.getId());

        System.out.println("\n=== Teste 5: seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marta");
        sellerDao.update(seller);
        System.out.println("Update Complete");

        System.out.println("\n=== Teste 6: seller Delete ===");
        System.out.print("Entre com um Id para deletar: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete Complete");

        sc.close();
    }
}
