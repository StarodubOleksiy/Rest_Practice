package springMVC.service;

import org.springframework.transaction.annotation.Transactional;
import springMVC.dao.EmployeeDao;
import springMVC.model.Employee;
import java.util.List;

/**
 * Created by Администратор on 31.07.16.
 */
public class EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public List<Employee> getEmployeeByName(String employeeName){
        return employeeDao.findByName(employeeName);
    }

    @Transactional
    public List<Employee> getEmployeeBySurName(String surName){
        return employeeDao.findBySurName(surName);
    }

    @Transactional
    public Employee getEmployeeByNameAndSurName(String name,String surName){
        return employeeDao.findByNameandSurName(name,surName);
    }



    @Transactional
    public Employee getEmployeeById(Long id){
        return employeeDao.findById(id);
    }



    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

}
