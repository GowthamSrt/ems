package com.ideas2it.ems.department.service;

import com.ideas2it.ems.department.dao.DepartmentRepository;
import com.ideas2it.ems.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return (departmentRepository.findById(id).isPresent() ? departmentRepository.findById(id).get() : null);
    }

    public Department updateDepartment(Department department, int id) {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            existingDepartment.setName(department.getName());
        }
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
