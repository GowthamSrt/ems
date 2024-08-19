package com.ideas2it.ems.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.ems.exception.EmsException;
import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.mapper.ProjectMapper;
import com.ideas2it.ems.department.mapper.DepartmentMapper;
import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dao.EmployeeRepository;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.mapper.EmployeeMapper;
import com.ideas2it.ems.model.Department;
import com.ideas2it.ems.model.Employee;
import com.ideas2it.ems.project.service.ProjectService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;


    public EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId) {
        try {
            Employee employee = EmployeeMapper.mapEmployee(employeeDto);
            Department department = DepartmentMapper.mapDepartment(departmentService.getDepartmentById(departmentId));
            if (null == department) {
                logger.warn("Department not found for ID" + departmentId);
                throw new EmsException("Department bot found for ID : " + departmentId, null);
            }

            employee.setDepartment(department);
            employee.setActive(true);
            Employee savedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.mapEmployeeDto(employeeRepository.save(savedEmployee));
        } catch (Exception e) {
            logger.warn("Error occurred while adding employee");
            throw new EmsException("Failed to add Employee", e);
        }
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        try {
            List<Employee> employeesActive = employeeRepository.findByIsActiveTrue();
            for (Employee employee : employeesActive) {
                employees.add(EmployeeMapper.mapEmployeeDto(employee));
            }
        } catch (Exception e) {
            logger.warn("Error while retrieving all the employees");
            throw new EmsException("Failed to retrieve employees", e);
        }
        return employees;
    }

    public EmployeeDto getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findByIdAndIsActiveTrue(id);
        return EmployeeMapper.mapEmployeeDto(employee
                .orElseThrow(() -> new RuntimeException("Employee not found for ID: " + id)));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id) {
        try {
            Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
            employee.setName(employeeDto.getName());
            employee.setDob(employeeDto.getDob());
            employee.setEmail(employeeDto.getEmail());
            employee.setMobileNumber(employeeDto.getMobileNumber());
            Department department = DepartmentMapper.mapDepartment(departmentService.getDepartmentById(id));
            employee.setDepartment(department);
            employee.setActive(true);
            return EmployeeMapper.mapEmployeeDto(employeeRepository.save(employee));

        } catch (Exception e) {
            logger.warn("Error while updating employee");
            throw new EmsException("Failed to update employee with ID : " + id, e);
        }

    }

    public void removeEmployee(int id) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public void addProjectToEmployee(int id, int projectId) {
        try {
            Optional<Employee> optionalEmployee = employeeRepository.findByIdAndIsActiveTrue(id);

            if (optionalEmployee.isEmpty()) {
                logger.warn("Employee not found with ID: {}", id);
                throw new EmsException("Employee not found with given ID: " + id);
            }
            Employee employee = optionalEmployee.get();

            Project project = ProjectMapper.mapProject(projectService.getProjectById(projectId));
            employee.getProjects().add(project);
            employeeRepository.save(employee);

            logger.info("Successfully added project with ID: {} to employee with ID: {}", projectId, id);
        } catch (EmsException e) {
            logger.error("EmsException while adding project to employee: {}", e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error while adding project to employee with ID: {}", id, e);
            throw new EmsException("Failed to add project to the employee with ID: " + id, e);
        }
    }

    public void removeProjectFromEmployee(int id, int projectId) {
            Employee employee = employeeRepository.findByIdAndIsActiveTrue(id)
                    .orElseThrow(() -> new EmsException("Employee not found with ID: " + id));
            Project project = projectService.getProjectById(projectId);
            if (null == project) {
                throw new EmsException("Project not found to this employee");
            }
            if (employee.getProjects().contains(project)) {
                employee.getProjects().remove(project);
                employeeRepository.save(employee);
                logger.info("Project with ID: {} successfully removed from Employee with ID: {}", projectId, id);
            } else {
                logger.warn("Employee with ID: {} does not have Project with ID: {}", id, projectId);
                throw new EmsException("Employee does not have Project with ID: " + projectId);
            }
    }

    public List<EmployeeDto> getEmployeesByDepartment(int departmentId) {
        try {
            List<Employee> employees = employeeRepository.findByDepartmentIdAndIsActiveTrue(departmentId);
            if (employees.isEmpty()) {
                logger.info("No employees found in this department");
                return new ArrayList<>();
            }
            List<EmployeeDto> employeeDtos = new ArrayList<>();
            for (Employee employee : employees) {
                employeeDtos.add(EmployeeMapper.mapEmployeeDto(employee));
            }
            return employeeDtos;
        } catch (Exception e) {
            logger.warn("Error while retrieving employees in this project");
            throw new EmsException("Failed to retrieve employee from the department with ID : " + departmentId, e);
        }
    }

    public List<EmployeeDto> getEmployeesByProject(int projectId) {
        try {
            List<Employee> employees = employeeRepository.findByProjectIdAndIsActiveTrue(projectId);
            if (employees.isEmpty()) {
                logger.info("No employee found in given project");
                return new ArrayList<>();
            }
            List<EmployeeDto> employeeDtos = new ArrayList<>();
            for (Employee employee : employees) {
                employeeDtos.add(EmployeeMapper.mapEmployeeDto(employee));
            }
            return employeeDtos;
        } catch (Exception e) {
            logger.warn("Error while retrieving employees from the given project");
            throw new EmsException("Failed to retrieve employees from given project with ID : " + projectId, e);
        }
    }
}