package io.github.thigassantos.templatejakarta.log;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LogBean implements LogBeanLocal {

    // Configurado para persistência local
    @PersistenceContext(unitName = "CredencialRemotePU")
    EntityManager remoto;

    @Override
    public void registrar(Log log) throws Exception {
        remoto.persist(log);
    }

    @Override
    public Log localizarPorId(Long id) {
        return remoto.find(Log.class, id);
    }

}
