package springMVC.hibernate;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import springMVC.model.Employee;
import springMVC.dao.EmployeeDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import springMVC.model.Menu;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional
    public Employee load(Long id) {
        Employee result = sessionFactory.getCurrentSession().load(Employee.class, id);
        if (result == null) {
            throw new RuntimeException("Cannot find Employee with ID:" + id);
        }
        return result;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" select e from Employee e").list();
    }

 //SELECT D.lastName FROM Developer D
    @Override
    @Transactional
    public List<Employee> findByName(String name) {
          Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e where e.name = :name").setParameter("name",name).list();
     }

    @Override
    @Transactional
    public List<Employee> findBySurName(String surName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e where e.surname = :surName").setParameter("surName",surName).list();

    }


    @Override
    @Transactional
    public Employee findByNameandSurName(String name, String surName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name =:name and e.surname = :surName");
        query.setParameter("surName",surName);
        query.setParameter("name",name);
        return (Employee)query.uniqueResult();

    }

    @Override
    @Transactional
    public Employee findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return  (Employee) session.get(Employee.class, id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void remove(Long id) {

        sessionFactory.getCurrentSession().delete(findById(id));
    }
}
