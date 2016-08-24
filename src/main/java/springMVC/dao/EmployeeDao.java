package springMVC.dao;


import springMVC.model.Employee;

import java.util.List;
public interface EmployeeDao {
    void save(Employee employee);
    Employee load(Long id);
    List<Employee> findAll();
    void remove(Long id);
    public List<Employee> findByName(String name);
    public List<Employee> findBySurName(String name);
    public Employee findByNameandSurName(String name, String surName);
    public Employee findById(Long id);

}
