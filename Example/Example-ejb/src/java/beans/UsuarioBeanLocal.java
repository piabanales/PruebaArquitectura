/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author docenteFI
 */
@Local
public interface UsuarioBeanLocal {

    String test(String param);

    List<String> getPersonas();
    
    String addUser(String name, String surname);
    
}
