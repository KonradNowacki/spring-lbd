package pl.fis.lbd.service;


import java.util.List;

public interface EmployeeService {

    List findAll();

    String getEmployeeByNickname(String firstName, String lastName);

}
