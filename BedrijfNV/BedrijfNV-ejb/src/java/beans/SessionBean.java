/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author student
 */
@Stateless
public class SessionBean implements SessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @PersistenceContext private EntityManager em; 
    public List getKredieten(){            
        List results = em.createQuery("SElECT k FROM Kredieten k").getResultList();
        return results;
    }
    public List getOnkosten(){
        List results = em.createQuery("SElECT o FROM Onkosten o").getResultList();
        return results;
    }
 
}
