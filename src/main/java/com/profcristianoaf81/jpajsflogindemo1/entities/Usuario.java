package com.profcristianoaf81.jpajsflogindemo1.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author cristianoaf81
 */
@Entity
@Data
@SuppressWarnings("PersistenceUnitPresent")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1841736507506902988L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="nome", nullable = false, length = 100)
    private String nomeUsuario;
    
    @Column(name="senha", nullable = false, length = 8 )
    private String senha;
    
    @Column(name="email", nullable = false, length = 100, unique = true)
    private String email;
    
    @Column(name="nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    
    @Column(name="ultimoacesso")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;

}
