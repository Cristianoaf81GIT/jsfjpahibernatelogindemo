package com.profcristianoaf81.jpajsflogindemo1.webfilter;

import com.profcristianoaf81.jpajsflogindemo1.Util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author cristianoaf81
 */
@WebFilter(urlPatterns = {"/JPAJSFLoginDemo1/*",})
public class HibernateFilter implements Filter
{
    private SessionFactory SessionFactory;
    private Session session;
    private Transaction transaction;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        SessionFactory = null;
        session = null;
        transaction = null;
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException 
    {
        try
        {
            SessionFactory = HibernateUtil.getSessionFactory();
            session = SessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            chain.doFilter(request, response);
            transaction.commit();
        }catch(Exception e)
        {
            try{
                if(transaction.isActive())
                    transaction.rollback();
            }catch(Throwable t){
               t.printStackTrace();
            }
        
            throw  new ServletException(e);
        }
        
    }

    @Override
    public void destroy() 
    {
       
    }

}
