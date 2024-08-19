package com.ideas2it.ems.employee;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dao.EmployeeRepository;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.service.EmployeeServiceImpl;
import com.ideas2it.ems.model.Department;
import com.ideas2it.ems.model.Employee;
import com.ideas2it.ems.project.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentService departmentService;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    EmployeeDto employeeDto;
    Employee employee;
    Department department;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee();
        employee.setName("Emma watson");
        employee.setDob(LocalDate.ofEpochDay(2000 - 11 - 11));
        employee.setEmail("emma@gmail.com");
        employee.setMobileNumber("9994136699");
        employee.setDepartment(department);
        employeeDto = new EmployeeDto();
        employeeDto.setName("Emma watson");
        employeeDto.setDob(LocalDate.ofEpochDay(2000 - 11 - 11));
        employeeDto.setEmail("emma@gmail.com");
        employeeDto.setMobileNumber("9994136699");
        employeeDto.setDepartmentId(department.getId());
        employeeDto.setDepartmentName(department.getName());
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setName("AAA");

    }

    @Test
    void testAddEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        when(departmentService.getDepartmentById(1)).thenReturn(DepartmentDto());

        EmployeeDto result = employeeService.addEmployee(employeeDto, 1);

        assertNotNull(result);
        assertEquals(employee.getName(), result.getName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }
}

