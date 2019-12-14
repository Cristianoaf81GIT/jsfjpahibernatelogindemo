package com.profcristianoaf81.jpajsflogindemo1.webfilter;

import com.profcristianoaf81.jpajsflogindemo1.entities.Usuario;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cristianoaf81
 */
@WebFilter(urlPatterns = ("/restricted/*"))
public class LoginFilter implements Filter{
    
     private Usuario loggedUser;
     private FacesContext context;
     

    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException 
    {
          
        //obtem objeto de requisicao
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // obtem objeto de resposta
        HttpServletResponse httpServletResponse = 
                (HttpServletResponse) response;
        //obtem a sessao
        HttpSession session = httpServletRequest.getSession();
        
        /*
        outra forma de obter o usuario logado
        context.getExternalContext().getSessionMap().get("usuarioLogado");
        */
        
        //verifica se a sessao existe e se o usuario esta logado
        // caso nao esteja obtemos o objeto        
        
        if(session == null || session.getAttribute("usuarioLogado") == null)
        {
            //obtem objeto usuario logado
            /*context = FacesContext.getCurrentInstance();
            
            loggedUser = (Usuario)
            context.getExternalContext()
            .getSessionMap().get("usuarioLogado"); */
            httpServletResponse
                    .sendRedirect("/JPAJSFLoginDemo1/?logged=false");
            
            
            
        }else{
            chain.doFilter(request, response);
        }    
        
    }

    @Override
    public void destroy() 
    {
        
    }

}
