/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.templatejakarta.credencial;

import io.github.thigassantos.templatejakarta.credencial.Credencial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IFNMG
 */
@Local
public interface CredencialBeanLocal {
    public void salvar(Credencial cr);
    public Credencial buscarId(long id);
    public void removerId(long id);
    public List<Credencial> buscarTodos();
}
