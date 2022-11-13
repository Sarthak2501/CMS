package com.ComplaintsManagementSystem.CMS.Service;


import com.ComplaintsManagementSystem.CMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService{

    List<Employee> findAllEmployees();

    Employee findEmployeeById(long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    boolean deleteEmployee(long id);
}
