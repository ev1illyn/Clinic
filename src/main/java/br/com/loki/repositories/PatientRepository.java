/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.repositories;

import br.com.loki.factory.Factory;
import br.com.loki.model.Patient;
import java.util.List;

/**
 *
 * @author Emilly Oliveira
 */
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class PatientRepository {

    // SALVA PACIENTE
    public void save(Patient patient) {
        EntityManager em = Factory.getManager();
        em.getTransaction().begin();
        try {
            em.persist(patient);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            System.out.println("deu erro ao salvar paciente");
        } finally {
            em.close();
        }
    }

    // ATUALIZA PACIENTE
    public void update(Patient patient) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            em.merge(patient);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    // REMOVE PACIENTES
    public void remove(String cpf) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Patient.class);
            criteria.add(Restrictions.ilike("cpf", cpf));
            Patient patient = (Patient) criteria.uniqueResult();
            em.remove(patient);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    // LISTA TODOS OS PACIENTES, JPQL
    public List<Patient> list() {
        EntityManager em = Factory.getManager();
        try {
            List<Patient> patient = em.createQuery("from Patient", Patient.class).getResultList();
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    // BUSCA PACIENTES POR CÓDIGO
    public Patient searchById(Integer id) {
        EntityManager em = Factory.getManager();
        try {
            Patient patient = em.find(Patient.class, id);
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    // BUSCA PACIENTE POR NOME OU CPF
    public Patient searchByNameOrCpf(String search) {
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Patient.class);
            criteria.createAlias("person", "person");
            Criterion criterion1 = Restrictions.ilike("person.name", search);
            Criterion criterion2 = Restrictions.ilike("person.cpf", search);
            criteria.add(Restrictions.or(criterion1, criterion2));
            Patient patient = (Patient) criteria.uniqueResult();
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
}
