package com.profcristianoaf81.jpajsflogindemo1.menagedbeans;

import com.profcristianoaf81.jpajsflogindemo1.dao.DaoFactory;
import com.profcristianoaf81.jpajsflogindemo1.entities.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.text.AbstractDocument;



/**
 *
 * @author cristianoaf81
 */

@SessionScoped
@ManagedBean(name="loginMB")
public class LoginManagedBean implements Serializable
{
    
    private String email;
    private String senha;
    private Usuario usuario = new Usuario();
   
    public Usuario getUsario() {
        return usuario;
    }

    public void setUsario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
       
    public String checkUser(){
        System.out.println(this.senha+" "+ this.email);
        
        if(this.senha.trim().equals("") || this.email.trim().equals("") )
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Falha",
                    new FacesMessage("Favor Preencha todos os campos"));
        }
        else
        {
             this.usuario = DaoFactory.getUsuarioLogado(email, senha);
             
             if(this.usuario!=null)
             {
                
                FacesContext context = FacesContext.getCurrentInstance();
                
                context.addMessage(
                     null,
                     new FacesMessage("Seja bem vindo(a) " 
                             + this.usuario.getNomeUsuario())
                );
                
                // cria a sessao do usuario
                context.getExternalContext()
                        .getSessionMap().put("usuarioLogado", this.usuario);
                
                // cria sessao de administrador (fake)
                //context.getExternalContext().getSessionMap().put("adm",null);
                
                this.usuario = new Usuario();
                
                return "restricted/index.jsf";
             }
             else
             {
                FacesContext context = FacesContext.getCurrentInstance();
                
                context.addMessage(
                     null,
                     new FacesMessage("Usuário não encontrado!")
                );
             }
             
        }
        
                
        return "";
    
    }
    

}
