package com.ComplaintsManagementSystem.CMS.Service.serviceImplement;

import com.ComplaintsManagementSystem.CMS.Model.Employee;
import com.ComplaintsManagementSystem.CMS.Repository.EmployeeRepository;
import com.ComplaintsManagementSystem.CMS.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = repository.findById(employee.getEmployeeId());
        if(employeeDb.isPresent()) {
            Employee emp = employeeDb.get();
            emp.setEmployeeId(employee.getEmployeeId());
            emp.setEmployeeName(employee.getEmployeeName());
            emp.setEmail(employee.getEmail());
            return repository.save(emp);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()) {
            repository.delete(employee.get());
            return true;
        }
        return false;
    }

}
