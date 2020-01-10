package com.yurets_y.mapping.one_to_many;


import com.yurets_y.mapping.one_to_many.entity.Email;
import com.yurets_y.mapping.one_to_many.entity.Employee;
import com.yurets_y.mapping.one_to_many.repo.EmailRepo;
import com.yurets_y.mapping.one_to_many.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyApplication.class,args);
    }


    public OneToManyApplication(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee("Yuriy","Gagarin");

        Email homeMail = new Email("gmail.com","Gagarin");
        Email workMail = new Email("ukr.net","Yuriy_Gagarin");

        employee.add(homeMail);
        employee.add(workMail);

        employeeRepo.save(employee);

        System.out.println("After saving: " + employee);
        System.out.println("Getting data from repo...");
        List<Employee> employees = employeeRepo.findAll();

        employees.forEach(employee1 -> {
            System.out.println(employee1);
            employee1.iterator().forEachRemaining(System.out::println);
        });


    }
}
