package com.ideas2it.ems.department.contoller;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.mapper.Mapper;
import com.ideas2it.ems.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        return Mapper.mapDepartmentDto(departmentService.addDepartment(Mapper.mapDepartment(departmentDto)));
    }

    @GetMapping("/department")
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> departments = new ArrayList<>();
        for (Department department : departmentService.getAllDepartments()) {
            departments.add(Mapper.mapDepartmentDto(department));
        }
        return departments;
    }

    @PutMapping("/department/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("id") int id) {
        return Mapper.mapDepartmentDto(departmentService.updateDepartment(Mapper.mapDepartment(departmentDto), id));
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment (@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "Department Deleted Successfully";
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") int id) {
        return Mapper.mapDepartmentDto(departmentService.getDepartmentById(id));
    }
}
