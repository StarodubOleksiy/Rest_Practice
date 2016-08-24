package springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springMVC.model.Employee;
import springMVC.service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 31.07.16.
 */
@Controller
@RestController
public class EmployeeController {



    private EmployeeService employeeService;


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
   // @ResponseBody
    public List<Employee> employees(Map<String, Object> model) {
          return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
   // @ResponseBody
    public List<Employee> employee(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @RequestMapping(value = "/employeeSurName/{surName}", method = RequestMethod.GET)
    // @ResponseBody
    public List<Employee> employeeBySurName(@PathVariable String surName) {
        return employeeService.getEmployeeBySurName(surName);
    }

    @RequestMapping(value = "/employeeById/{employeeId}", method = RequestMethod.GET)
    // @ResponseBody
    public Employee employeeById(@PathVariable long employeeId) {
        return employeeService.getEmployeeById(/*Long.parseLong(*/employeeId/*)*/);
    }

    @RequestMapping(value = "/employeeByNameAndSurname/{employeeName}/{employeeSurName}", method = RequestMethod.GET)
    // @ResponseBody
    public Employee employeeByNameAndSurname(@PathVariable String employeeName , @PathVariable String employeeSurName) {
        return employeeService.getEmployeeByNameAndSurName(employeeName,employeeSurName);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
