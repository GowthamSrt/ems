package com.ideas2it.ems.employee.mapper;

import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public static EmployeeDto mapEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setDob(employee.getDob());
        employeeDto.setDepartmentId(employee.getDepartment().getId());
        employeeDto.setDepartmentName(employee.getDepartment().getName());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    public static Employee mapEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setDob(employeeDto.getDob());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        return employee;
    }
}
