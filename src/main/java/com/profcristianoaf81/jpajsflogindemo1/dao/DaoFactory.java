package com.profcristianoaf81.jpajsflogindemo1.dao;

import com.profcristianoaf81.jpajsflogindemo1.Util.HibernateUtil;
import com.profcristianoaf81.jpajsflogindemo1.entities.Usuario;
import java.io.Serializable;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author cristianoaf81
 */
public class DaoFactory implements Serializable
{

    private static final long serialVersionUID = -5544805384676247507L;
    
    public static Usuario getUsuarioLogado(String email, String senha)
    {
        try{
            
            Session session = 
                    HibernateUtil.getSessionFactory().getCurrentSession();
            
            session.beginTransaction();
            
            Query findUser = session.createQuery(
                    "SELECT u from Usuario u where u.email = : email"
                            + " and u.senha = :senha", Usuario.class);
            findUser.setParameter("email", email);
            findUser.setParameter("senha", senha);
            Usuario loggedUser = (Usuario) findUser.getSingleResult();
            
            if(loggedUser!=null)
                session.close();
            
            return loggedUser;
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        
        
    }
    
}
