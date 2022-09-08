/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.templatejakarta.resources;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
