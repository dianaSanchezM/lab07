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
public class infoServicesStub implements CommandLineRunner,InformationServices{
    
    @Autowired
	private ConsultaRepository consultRepository;
    
    @Autowired
    HttpConnection conection;
    
    private String json;
    private String id;
    private String hist;
    
    @Override
    public String getInfo(String hist,String identifier) throws InfoServicesException {
        conection.connect(hist, identifier);
        try {
            id=identifier;
            this.hist=hist;
            Consulta consulta = consultRepository.findByIdentifier(identifier+" "+hist);
            if (consulta==null){
                System.out.println("No esta en la base de datos");
                conection.run();
                json=conection.getResult();
                consulta=new Consulta(id+" "+hist,json);
                consultRepository.save(consulta);
            }
            return consulta.json;
        } catch (IOException ex) {
            Logger.getLogger(infoServicesStub.class.getName()).log(Level.SEVERE, null, ex);
            throw new InfoServicesException("ERROR CONECTANDO");
        }
        
    }

    @Override
    public void run(String... args) throws Exception {
        consultRepository.deleteAll();
        System.out.println("CONECTION TO MONGODB");
    }

    
    
}
