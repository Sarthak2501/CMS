package com.ComplaintsManagementSystem.CMS.Repository;

import com.ComplaintsManagementSystem.CMS.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
