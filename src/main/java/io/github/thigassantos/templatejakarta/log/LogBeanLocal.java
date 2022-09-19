/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.templatejakarta.log;

import javax.ejb.Local;

/**
 * Interface para configuração da implementação do EJB para Log
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&lt;
 * @since 0.1, 2022-09-16
 */
@Local
public interface LogBeanLocal {

    void registrar(Log log) throws Exception;

    Log localizarPorId(Long id);

}