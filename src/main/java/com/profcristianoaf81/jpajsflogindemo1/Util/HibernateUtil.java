package com.profcristianoaf81.jpajsflogindemo1.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author cristianoaf81
 */
public class HibernateUtil 
{
    
    private static final SessionFactory SESSION_FACTORY =
            createSessionFactory();
    
    
    private static SessionFactory createSessionFactory() 
    {
        
        try{
            
            final StandardServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml").build();
            
            
            return new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
            
        }catch(Exception e){
            
            String message = "Não foi possível criar a session Factory "
                    +e.getMessage();
            
            throw new ExceptionInInitializerError(e);
        }
    
    }
    
    public static SessionFactory getSessionFactory()
    {
        return SESSION_FACTORY;
    }

}
