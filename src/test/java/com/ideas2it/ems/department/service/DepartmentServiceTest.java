package com.ideas2it.ems.department.service;

import com.ideas2it.ems.department.dao.DepartmentRepository;
import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.model.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private List<Department> departments;

    @Test
    void testAddDepartment() {
        Department department = new Department();
        department.setId(1);
        department.setName("HR");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(1);
        departmentDto.setName("HR");
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        DepartmentDto createdDepartment = departmentService.addDepartment(departmentDto);
        assertEquals(departmentDto.getName(), createdDepartment.getName());
        verify(departmentRepository, times(1)).save(any(Department.class));
    }

    @Test
    void testGetAllDepartments() {
        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Admin");
        Department department2 = new Department();
        department2.setId(2);
        department2.setName("HR");
        List<Department> departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);
        when(departmentRepository.findAll()).thenReturn(departments);
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartments();
        assertNotNull(departmentDtos);
        assertEquals(2, departmentDtos.size());
        assertEquals("Admin", departmentDtos.get(0).getName());
        assertEquals("HR", departmentDtos.get(1).getName());

        verify(departmentRepository, times(1)).findAll();
    }

    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setId(2);
        department.setName("Hr");
        when(departmentRepository.findById(2)).thenReturn(Optional.of(department));
        Department result = departmentRepository.findById(2).isPresent() ? departmentRepository.findById(2).get() : null;
        assertEquals(department,result);
    }

    @Test
    void removeDepartment() {
        Department department = new Department();
        department.setId(3);
        department.setName("Admin");
        when(departmentRepository.findById(3)).thenReturn(Optional.of(department));
        departmentService.deleteDepartment(3);
        verify(departmentRepository, times(1)).deleteById(3);
    }

    @Test
    void testUpdateDepartment() {
        Department department = new Department();
        department.setId(1);
        department.setName("Admin");
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(1);
        departmentDto.setName("Admin");
        when(departmentRepository.findById(1)).thenReturn(Optional.of(department));
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentDto, 1);
        assertNotNull(updatedDepartment);
        assertEquals("Admin", updatedDepartment.getName());
    }
}

