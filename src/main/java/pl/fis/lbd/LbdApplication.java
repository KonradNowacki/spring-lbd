package pl.fis.lbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.fis.lbd.service.EmployeeService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LbdApplication {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(LbdApplication.class, args);
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("From post construct");
        employeeService.findAll();
        System.out.println(employeeService.getEmployeeByNickname("Konrad", "Nowacki"));
    }

}
