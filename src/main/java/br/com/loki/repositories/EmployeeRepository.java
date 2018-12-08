/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loki.repositories;

import br.com.loki.factory.Factory;
import br.com.loki.model.Employee;
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
public class EmployeeRepository {

    // SALVA FUNCIONÁRIOS
    public void save(Employee employee) {
        EntityManager em = Factory.getManager();
        em.getTransaction().begin();
        try {
            em.persist(employee);
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

    // ATUALIZA FUNCIONÁRIOS
    public void update(Employee employee) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            em.merge(employee);
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

    // REMOVE FUNCIONÁRIOS
    public void remove(String cpf) {
        EntityManager em = Factory.getManager();
        try {
            em.getTransaction().begin();
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.ilike("cpf", cpf));
            Employee employee = (Employee) criteria.uniqueResult();
            em.remove(employee);
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

    // LISTA TODOS OS FUNCIONÁRIOS, JPQL
    public List<Employee> list() {
        EntityManager em = Factory.getManager();
        try {
            List<Employee> employee = em.createQuery("from Employee", Employee.class).getResultList();
            return employee;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

    }

    // BUSCA FUNCIONÁRIO POR CÓDIGO
    public Employee searchById(Integer id) {
        EntityManager em = Factory.getManager();
        try {
            Employee employee = em.find(Employee.class, id);
            return employee;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    // BUSCA FUNCIONÁRIO POR CARGO OU CPF
    public List<Employee> searchByPostOrCpf(String search) {
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Employee.class);
            Criterion criterion1 = Restrictions.ilike("post", search);
            Criterion criterion2 = Restrictions.ilike("cpf", search);
            criteria.add(Restrictions.or(criterion1, criterion2));
            List<Employee> employeers = criteria.list();
            return employeers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

    }

    // AUTENTICA LOGIN DO USUÁRIO/FUNCIONÁRIO
    public Employee authenticateLogin(String user, String password) {
        EntityManager em = Factory.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Employee.class);
            Criterion criterion1 = Restrictions.ilike("user", user);
            Criterion criterion2 = Restrictions.ilike("password", password);
            criteria.add(Restrictions.and(criterion1, criterion2));
            Employee employee = (Employee) criteria.uniqueResult();
            return employee;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

}
