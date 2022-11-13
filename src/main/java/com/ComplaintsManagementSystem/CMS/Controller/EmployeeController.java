package com.ComplaintsManagementSystem.CMS.Controller;


import com.ComplaintsManagementSystem.CMS.Model.Employee;
import com.ComplaintsManagementSystem.CMS.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(employeeService.findAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
    }

    @PostMapping("")
    public ResponseEntity <Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}


