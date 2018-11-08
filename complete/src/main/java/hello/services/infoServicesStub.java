/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.services;

import hello.Customer;
import hello.CustomerRepository;
import hello.conection.Conection;
import hello.conection.HttpConnection;
import hello.model.Consulta;
import hello.model.ConsultaRepository;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author diana
 */
@Service
public class infoServicesStub implements InformationServices, CommandLineRunner{
    @Autowired
	private CustomerRepository repository;
    
    @Autowired
	private ConsultaRepository consultRepository;
    
    @Autowired
    HttpConnection conection;
    
    private String jason;
    private String id;
    private String hist;
    
    @Override
    public String getInfo(String hist,String identifier) throws InfoServicesException {
        conection.connect(hist, identifier);
        try {
            conection.run();
            id=identifier;
            this.hist=hist;
            jason=conection.getResult();
            return jason;
        } catch (IOException ex) {
            Logger.getLogger(infoServicesStub.class.getName()).log(Level.SEVERE, null, ex);
            throw new InfoServicesException("ERROR CONECTANDO");
        }
        
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
                consultRepository.save(new Consulta(id,hist,jason));
		// save a couple of customers
		//repository.save(new Customer("Alice", "Smith"));
                /*
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}*/
    }
    
}
