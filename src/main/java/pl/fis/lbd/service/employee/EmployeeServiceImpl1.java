package pl.fis.lbd.service.employee;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.fis.lbd.entity.employee.Employee;
import pl.fis.lbd.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Profile("dev")
@Service
public class EmployeeServiceImpl1 implements EmployeeService {

    private Map<Long, Employee> database = new HashMap<>();

    @Value( "${lbd.prefix}")
    private String prefix;

    @Value( "${lbd.suffix}")
    private String suffix;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl1.class);

    @Override
    public List findAll() {
        return null;
    }

    public String getEmployeeByNickname(String firstName, String lastName) {
        LOG.info("firstName: " + firstName + " lastName: " + lastName);
        String nickname = prefix + firstName.substring(0, 3) + lastName.substring(0, 3) + suffix;
        LOG.info("nickname: " + nickname);
        return nickname;
    }

    public Employee findByName(String name) {
        for (Employee emp: database.values()) {
            if (emp.getFirstName().equals(name) || emp.getLastName().equals(name)) {
                return emp;
            }
        }
        return null;
    }

    public void save(Employee employee) {
        database.put(employee.getId(), employee);
    }

}
