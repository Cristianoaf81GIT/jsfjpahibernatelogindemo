
import com.profcristianoaf81.jpajsflogindemo1.Util.HibernateUtil;
import com.profcristianoaf81.jpajsflogindemo1.dao.DaoFactory;
import com.profcristianoaf81.jpajsflogindemo1.entities.Usuario;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 *
 * @author cristianoaf81
 */
public class TestDaoClass{
    /*@Test
    public void TestDao(){
        DaoFactory daoFactory = new DaoFactory();
        Usuario u = daoFactory
                .getUsuarioLogado("cristianoaf81@email.com", "123");
        if(u!=null)
            System.out.println(u.getNomeUsuario());
        
    
    }*/

}
