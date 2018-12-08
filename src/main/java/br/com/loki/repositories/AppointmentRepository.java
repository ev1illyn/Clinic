/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.repositories;

import br.com.loki.factory.Factory;
import br.com.loki.model.Appointment;
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
public class AppointmentRepository {

    // SALVA AGENDAMENTOS
    public void save(Appointment appointment) {
        EntityManager em = Factory.getManager();
        em.getTransaction().begin();
        try {
            em.persist(appointment);
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

    // ATUALIZA AGENDAMENTOS
    public void update(Appointment appointment) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            em.merge(appointment);
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

    // REMOVE AGENDAMENTOS
    public void remove(Integer id) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            Appointment appointment = em.find(Appointment.class, id);
            em.remove(appointment);
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

    public Appointment searchById(Integer id) {
        EntityManager em = Factory.getManager();
        try {
            Appointment appointment = em.find(Appointment.class, id);
            return appointment;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<Appointment> list() {
        EntityManager em = Factory.getManager();
        try {
            List<Appointment> appointment = em.createQuery("from Appointment", Appointment.class).getResultList();
            return appointment;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<Appointment> searchByDoctorOrPatient(String search) {
        EntityManager em = Factory.getManager();
        try {
            // CRIA SESSION PARA EXECUTAR A CRITERIA
            Session session = (Session) em.getDelegate();
            // API PRA EXECUTAR CONSULTAS EM CLASSES, ATRAVÉS DO SESSION
            Criteria criteria = session.createCriteria(Appointment.class);
            // CRIA JUNÇÃO COM TABELA DE MÉDICOS
            criteria.createAlias("doctor", "doctor");
            // CRIA CRITERION(INTERFACE QUE REPRESENTA CRITERIOS DE BUSCA
            // RESTRICTIONS (MÉTODOS EQ, ILIKE, IN...)
            Criterion c1 = Restrictions.ilike("doctor.crm", search);
            // CRIA JUNÇÃO COM TABELA PACIENTES
            criteria.createAlias("patient", "patient");
            // CRIA UMA NOVA JUNÇÃO COM A TABELA PERSON
            criteria.createAlias("patient.person", "person");
            Criterion c2 = Restrictions.ilike("person.name", search);
            criteria.add(Restrictions.or(c1, c2));
            // .LIST() RETORNA A LISTA DE RESULTADOS DA BUSCA NO BD
            List<Appointment> appointments = criteria.list();
            return appointments;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public Appointment authenticateDoctorCrm(String doctorCrm) {
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Appointment.class);
            criteria.createAlias("doctor", "doctor");
            Criterion c1 = Restrictions.ilike("doctor.crm", doctorCrm);
            criteria.add(c1);
            Appointment appointment = (Appointment) criteria.uniqueResult();
            return appointment;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
    public Appointment authenticatePatientCpf(String patientCpf){
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Appointment.class);
            criteria.createAlias("doctor", "doctor");
            Criterion c1 = Restrictions.ilike("doctor.crm", patientCpf);
            criteria.add(c1);
            Appointment appointment = (Appointment) criteria.uniqueResult();
            return appointment;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
