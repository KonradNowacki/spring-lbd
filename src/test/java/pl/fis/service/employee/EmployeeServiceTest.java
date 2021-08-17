package pl.fis.service.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import pl.fis.lbd.entity.employee.Employee;
import pl.fis.lbd.service.EmployeeService;
import pl.fis.lbd.service.employee.EmployeeServiceImpl1;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = {"lbd.prefix=bbb"})
class EmployeeServiceTest {

//    @Test
//    void getUserByNicknameReturnsCorrectly() {
//        EmployeeService employeeService = new EmployeeServiceImpl1();
//        String nickname = employeeService.getEmployeeByNickname("Konrad", "Nowacki");
//        assertThat(nickname).isEqualTo("aaaKonNowzzz");
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
        employeeService.save(emp1);

        Employee foundEmployeeByLastName = employeeService.findByName("Rambo");
        Employee foundEmployeeByFirstName = employeeService.findByName("John");

        assertThat(foundEmployeeByLastName).isEqualTo(emp1);
        assertThat(foundEmployeeByFirstName).isEqualTo(emp1);
    }

}
