/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Persona;
import domain.PersonaEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author docenteFI
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {
    
    @EJB
    private SingletonBeanLocal singletonBean;
    
    @PersistenceContext
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void add(PersonaEntity persona){
        em.persist(persona);
    }
    
    @Override
    public String test(String param) {
        return "Test: " + param;
    }

    @Override
    public List<String> getPersonas() {
        return singletonBean.getPersonas();
    }
    
    @Override
    public String addUser(String name, String surname){
        Persona p = new Persona(name, surname);
        singletonBean.addPersona(p);
        return "OK";
    }
    
    
}
