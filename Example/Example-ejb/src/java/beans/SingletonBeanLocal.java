/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author docenteFI
 */
@Local
public interface SingletonBeanLocal {

    String getState();
    
    String setState(String state);
    
    List<String> getPersonas();
    
    void addPersona(Persona p);
    
}
