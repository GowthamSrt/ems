package com.ideas2it.ems.department.contoller;

import java.util.List;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.addDepartment(departmentDto);
    }

    @GetMapping("/department")
    public List<DepartmentDto> getAllDepartments() {
       return departmentService.getAllDepartments();
    }

    @PutMapping("/department/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("id") int id) {
        return departmentService.updateDepartment((departmentDto), id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment (@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "Department Deleted Successfully";
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") int id) {
        return departmentService.getDepartmentById(id);
    }
}
