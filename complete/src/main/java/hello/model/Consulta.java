/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author 2108310
 */
public class Consulta {
    @Id
    public String identifier;
    public String historico;
    public String jason;

    public Consulta() {
    }

    public Consulta(String identifier, String historico, String jason) {
        this.identifier = identifier;
        this.historico = historico;
        this.jason = jason;
    }
    
    
}
