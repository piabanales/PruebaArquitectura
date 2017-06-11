/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author docenteFI
 */
@Stateless
public class ExampleBean implements ExampleBeanLocal {

    @Override
    public String example(String param) {
        return "Example: " + param;
    }
    
    @Override
    public String hola(){
        return "Hola Mundo";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
