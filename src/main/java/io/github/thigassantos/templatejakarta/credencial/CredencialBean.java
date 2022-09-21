/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.templatejakarta.credencial;

import io.github.thigassantos.templatejakarta.credencial.Credencial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author IFNMG
 */
@Stateless
public class CredencialBean implements CredencialBeanLocal{

    @PersistenceContext(unitName = "CredencialPU")
    EntityManager entityManager;
    
    @Override
    public void salvar(Credencial cr) {
       entityManager.persist(cr);
    }
    
    @Override
    public Credencial buscarId(long id){
        return entityManager.find(Credencial.class,id);
    }
    
    @Override
    public void removerId(long id){
        Credencial cr = entityManager.find(Credencial.class,id);
        entityManager.remove(cr);
    }
    
    @Override
    public List<Credencial> buscarTodos(){
        TypedQuery q = entityManager.createQuery("SELECT p FROM Credencial p", Credencial.class);
        return q.getResultList();
    }
    
    @Override
    public void atualizar(Credencial cr){
        Credencial cr2 = entityManager.find(Credencial.class,cr.getId());
        cr.setPass(cr2.getPass());
        entityManager.merge(cr);
    }
    
}
