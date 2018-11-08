package hello;


import hello.conection.Conection;
import hello.conection.HttpConnection;
import hello.services.InfoServicesException;
import static org.junit.Assert.assertEquals;
import hello.services.infoServicesStub;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diana
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={hello.Application.class})
public class InfoServicesStubTest {
    @Autowired
    private HttpConnection coneccion1;
    @Autowired
    private HttpConnection coneccion2;
    @Autowired
    private HttpConnection coneccion3;
    @Test
    public void contextLoad(){
        
    }
    
    @Test
    public void getInfoTest(){
            
           
        try {
            coneccion1.connect("Semanal","MSFT");
            coneccion2.connect("Semanal","MSFT");
            coneccion3.connect("Semanal","MSFT");
            coneccion1.run();
            coneccion2.run();
            coneccion3.run();
            String respuesta1 = coneccion1.getResult();
            String respuesta2 = coneccion2.getResult();
            String respuesta3 = coneccion3.getResult();
            assertEquals(respuesta1.substring(0, 125), "{    \"Meta Data\": {        \"1. Information\": \"Weekly Prices (open, high, low, close) and Volumes\",        \"2. Symbol\": \"MSFT\"");
            assertEquals(respuesta2.substring(0, 125), "{    \"Meta Data\": {        \"1. Information\": \"Weekly Prices (open, high, low, close) and Volumes\",        \"2. Symbol\": \"MSFT\"");
            assertEquals(respuesta3.substring(0, 125), "{    \"Meta Data\": {        \"1. Information\": \"Weekly Prices (open, high, low, close) and Volumes\",        \"2. Symbol\": \"MSFT\"");
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
