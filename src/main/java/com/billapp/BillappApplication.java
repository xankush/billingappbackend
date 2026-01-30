package com.billapp;
import com.billapp.services.implementation.Customerservicesimp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillappApplication implements CommandLineRunner {

    private final Customerservicesimp customerservicesimp;


    BillappApplication(Customerservicesimp customerservicesimp) {
        this.customerservicesimp = customerservicesimp;
    }
	
	
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
