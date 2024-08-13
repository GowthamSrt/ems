package com.ideas2it.ems.department.service;

import com.ideas2it.ems.department.dao.DepartmentRepository;
import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.department.mapper.DepartmentMapper;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.model.Department;
import com.ideas2it.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapDepartment(departmentDto);
        return DepartmentMapper.mapDepartmentDto(departmentRepository.save(department));
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> departments = new ArrayList<>();
        for (Department department : departmentRepository.findAll()) {
            departments.add(DepartmentMapper.mapDepartmentDto(department));
        }
        return departments;
    }

    public DepartmentDto getDepartmentById(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return DepartmentMapper.mapDepartmentDto(department.get());
        }
        else {
            return null;
        }
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int id) {
        Department existingDepartment = DepartmentMapper.mapDepartment(getDepartmentById(id));
        existingDepartment.setName(departmentDto.getName());
        return DepartmentMapper.mapDepartmentDto(departmentRepository.save(existingDepartment));
    }


    public void deleteDepartment(int id) {
        Department department = DepartmentMapper.mapDepartment(getDepartmentById(id));
        departmentRepository.deleteById(id);
    }
}
