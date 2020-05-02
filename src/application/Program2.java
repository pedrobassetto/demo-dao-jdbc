package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Teste 1: departmnet findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n=== Teste 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== Teste 3: department Update ===");
        department = departmentDao.findById(8);
        department.setName("D3526");
        departmentDao.update(department);
        System.out.println("Update Complete");

        System.out.println("=== Teste 4: department insert ===");
        department = new Department(null, "D4");
        departmentDao.insert(department);
        System.out.println("Inserção Feita");

        System.out.println("=== Teste 4: department delete ===");
        System.out.print("Entre com um Id para deletar: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Complete");

        sc.close();
    }
}
