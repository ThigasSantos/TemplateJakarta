/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.templatejakarta.resources;

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

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void salvar(Credencial cr) {
       entityManager.persist(cr);
    }
    
    public Credencial buscarId(long id){
        return entityManager.find(Credencial.class,id);
    }
    
    public void removerId(long id){
        Credencial cr = entityManager.find(Credencial.class,id);
        entityManager.remove(cr);
    }
    
    public List<Credencial> buscarTodos(){
        TypedQuery q = entityManager.createQuery("SELECT p FROM Credencial p", Credencial.class);
        return q.getResultList();
    }
    
}
