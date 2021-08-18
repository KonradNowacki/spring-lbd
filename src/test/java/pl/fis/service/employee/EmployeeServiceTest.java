package pl.fis.service.employee;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.fis.lbd.entity.employee.Employee;
import pl.fis.lbd.service.EmployeeService;
import pl.fis.lbd.service.employee.EmployeeServiceImpl1;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmployeeService.class)
@TestPropertySource(properties = {"lbd.prefix=aaa", "lbd.suffix=zzz"})
class EmployeeServiceTest {

    // Doesn't work, couldn't mock application.properties properly
//    @Test
//    void getUserByNicknameReturnsCorrectly() {
//        EmployeeService employeeService = new EmployeeServiceImpl1();
//        String nickname = employeeService.getEmployeeByNickname("John", "Rambo");
//        assertThat(nickname).isEqualTo("aaaJohRamzzz");
//    }


    // Integration test
    @Test
    void saveAndSearchInDatabaseCorrectly() {
        Employee emp1 = new Employee();
        emp1.setId(Long.valueOf(1));
        emp1.setFirstName("John");
        emp1.setLastName("Rambo");

        EmployeeService employeeService = new EmployeeServiceImpl1();
        employeeService.save(emp1);

        Employee foundEmployeeByLastName = employeeService.findByName("Rambo");
        Employee foundEmployeeByFirstName = employeeService.findByName("John");

        assertThat(foundEmployeeByLastName).isEqualTo(emp1);
        assertThat(foundEmployeeByFirstName).isEqualTo(emp1);
    }

}
