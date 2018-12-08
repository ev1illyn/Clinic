/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.repositories;

import br.com.loki.factory.Factory;
import br.com.loki.model.Doctor;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Emilly Oliveira
 */
public class DoctorRepository {

    // SALVA MÉDICOS
    public void save(Doctor doctor) {
        EntityManager em = Factory.getManager();
        em.getTransaction().begin();
        try {
            em.persist(doctor);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ATUALIZA MÉDICOS
    public void update(Doctor doctor) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            em.merge(doctor);
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

    // REMOVE MÉDICOS
    public void remove(String cpf) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Doctor.class);
            criteria.add(Restrictions.ilike("cpf", cpf));
            Doctor doctor = (Doctor) criteria.uniqueResult();
            em.remove(doctor);
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

    // BUSCA MÉDICOS POR ID
    public Doctor searchById(Integer id) {
        EntityManager em = Factory.getManager();
        try {
            Doctor doctor = em.find(Doctor.class, id);
            return doctor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    // LISTA TODOS OS MÉDICOS, JPQL
    public List<Doctor> list() {
        EntityManager em = Factory.getManager();
        try {
            List<Doctor> doctor = em.createQuery("from Doctor", Doctor.class).getResultList();
            return doctor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    // BUSCA MÉDICO POR CRM OU ESPECIALIZAÇAO
    public List<Doctor> searchByLicenseNumberOrSpecialization(String search) {
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Doctor.class);
            Criterion criterion1 = Restrictions.ilike("license_number", search);
            Criterion criterion2 = Restrictions.ilike("specialization", search);
            criteria.add(Restrictions.or(criterion1, criterion2));
            List<Doctor> doctors = criteria.list();
            return doctors;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

    }
}
