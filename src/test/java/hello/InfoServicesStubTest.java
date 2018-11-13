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
        
        
    }
}
