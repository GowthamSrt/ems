package com.ideas2it.ems.employee.mapper;

import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.model.Employee;
import com.ideas2it.ems.util.DateUtil;
import org.springframework.stereotype.Component;

/**
 * <p>
 * EmployeeMapper is responsible for converting between Employee entities and EmployeeDto objects.
 * It helps in mapping entity objects to DTOs and vice versa.
 * </p>
 */
@Component
public class EmployeeMapper {

    /**
     * <p>
     * Maps an Employee entity to an EmployeeDto.
     * </p>
     *
     * @param employee The Employee entity to map.
     * @return The mapped EmployeeDto object.
     */
    public static EmployeeDto mapEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setDob(employee.getDob());
        employeeDto.setAge(DateUtil.calculateAge(employee.getDob()));
        employeeDto.setDepartmentId(employee.getDepartment().getId());
        employeeDto.setDepartmentName(employee.getDepartment().getName());
        employeeDto.setMobileNumber(employee.getMobileNumber());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    /**
     * <p>
     * Maps an EmployeeDto to an Employee entity.
     * </p>
     *
     * @param employeeDto The EmployeeDto to map.
     * @return The mapped Employee entity.
     */
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
