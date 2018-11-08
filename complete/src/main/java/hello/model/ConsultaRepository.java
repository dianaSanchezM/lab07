/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 2108310
 */
public interface ConsultaRepository extends MongoRepository<Consulta, String> {
    public Consulta findByFirstName(String f);
    public List<Consulta> findByLastName(String lastName);
}
