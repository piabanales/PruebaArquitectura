/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author docenteFI
 */
@Singleton
public class SingletonBean implements SingletonBeanLocal {
    
    private String state;
    private List<Persona> users;
    
    @PostConstruct
    void init() {
      state = "Ready";
      users = new ArrayList<Persona>();
      Persona p = new Persona("Juan", "Perez");
      Persona p2 = new Persona("Jorge", "Gonzalez");
      users.add(p);
      users.add(p2);
    }
    
    @Override
    public List<String> getPersonas() {
        List<String> list = new ArrayList<String>();
        for(Persona p : users){
            list.add(p.toString());
        }
        return list;
    }
    
    public void addPersona(Persona p){
        this.users.add(p);
    }

    @Override
    public String getState() {
        return state;
    }
    
    @Override
    public String setState(String state) {
        String previous = new String(this.state);
        this.state = state; 
        return "State: " + previous + "->" + state;
    }
    
    
}
