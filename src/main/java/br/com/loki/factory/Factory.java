/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emilly Oliveira
 */
public class Factory {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("OrmPU");
    }

    private Factory() {

    }

    /**
     * retorna um gerenciador valido
     *
     * @return
     */
    public static EntityManager getManager() {
        return emf.createEntityManager();
    }

    public static void closeConnection() {
        emf.close();
    }
}
