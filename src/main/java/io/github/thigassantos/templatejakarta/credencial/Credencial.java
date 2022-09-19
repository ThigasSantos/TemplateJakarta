package io.github.thigassantos.templatejakarta.credencial;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Tygsv
 */
@Entity
public class Credencial implements Serializable{
    
    @Id
    public long id;
    public String name;
    public String email;
    public String pass;
    public Boolean ativo;

//<editor-fold defaultstate="collapsed" desc="Getters and Setters">
      public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
//</editor-fold>
   
        @Override
    public String toString() {
        return "Credencial{"
                + "id=" + id
                + ", nome=" + name
                + ", email=" + email
                + ", password=" + pass
                + ", ativo=" + ativo
                + '}';
    }
}
