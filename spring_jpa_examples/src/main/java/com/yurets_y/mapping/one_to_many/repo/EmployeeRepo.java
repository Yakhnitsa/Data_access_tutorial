package com.yurets_y.mapping.one_to_many.repo;

import com.yurets_y.mapping.one_to_many.entity.Email;
import com.yurets_y.mapping.one_to_many.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {


}
