package pl.fis.lbd.service;


import pl.fis.lbd.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {

    List findAll();

    String getEmployeeByNickname(String firstName, String lastName);

    Employee findByName(String name);

    void save(Employee employee);

}
