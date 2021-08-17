package pl.fis.lbd.service.employee;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fis.lbd.entity.employee.Employee;
import pl.fis.lbd.service.EmployeeService;

import java.util.List;

@Profile("prod")
@Service
public class EmployeeServiceImpl2 implements EmployeeService {

    @Value( "${lbd.prefix}")
    private String prefix;

    @Value( "${lbd.suffix}")
    private String suffix;

    @Override
    public List findAll() {
        return null;
    }

    public String getEmployeeByNickname(String firstName, String lastName) {
        return prefix + firstName.substring(0, 3) + lastName.substring(0, 3) + suffix;
    }

    @Override
    public Employee findByName(String name) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

}
