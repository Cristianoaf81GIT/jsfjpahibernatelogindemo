/**
 *
 * @author cristianoaf81
 */

import junit.framework.TestCase;
import com.profcristianoaf81.jpajsflogindemo1.Util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;
import com.profcristianoaf81.jpajsflogindemo1.entities.Usuario;
import java.util.Calendar;
import java.util.Date;

public class TestHibernateConnection extends TestCase{
    
    public static void testConnection(){
        //@Test
        /*Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        System.out.println(session.isOpen());
        Usuario u = new Usuario();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1981, 04, 19);
        Date BirthDate = new Date(calendar.getTimeInMillis());
        System.out.println(BirthDate);
        u.setEmail("cristianoaf81@email.com");
        u.setNomeUsuario("cristianoaf81");
        u.setSenha("123");
        u.setDataNasc(BirthDate);
        u.setUltimoAcesso(new Date());
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();        */
        
    }
}
