package com.billapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.billapp.Dao.CustomerListrepository;

@SpringBootApplication
public class BillappApplication implements CommandLineRunner {
	@Autowired
	private CustomerListrepository customerrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BillappApplication.class, args);
	
		
	}
		
	public void run(String... args) throws Exception {
        // This code runs once after startup
        System.out.println("App started, running CommandLineRunner...");

        // Example: test your service or repository here
        // customerService.saveCustomer(new Customer(...));
//        Customer c = new Customer(19,"ankushdo","tyc","9898979898");
//        
//        Renteditem r1 = new Renteditem("farsh","12");
//        r1.setCustomer(c);
//        Renteditem r2 = new Renteditem("chadar","14");
//        r2.setCustomer(c);
//        List<Renteditem> rentitemlist = new ArrayList<>();
//        rentitemlist.add(r1);
//        rentitemlist.add(r2);
//        
//        c.setRenteditemlist(rentitemlist);
//        
//        
//       
//        
//        customerrepo.save(c);
        
        
        
        
        
    }
}
