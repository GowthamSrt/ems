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

/**
 * <p>
 * DepartmentController handles incoming HTTP requests related to departments.
 * It interacts with the DepartmentService to perform CRUD operations on departments.
 * </p>
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * <p>
     * Adds a new department.
     * </p>
     *
     * @param departmentDto The department data transfer object containing department details.
     * @return The added DepartmentDto object.
     */
    @PostMapping("/department")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.addDepartment(departmentDto);
    }

    /**
     * <p>
     * Retrieves all active departments.
     * </p>
     *
     * @return A list of DepartmentDto objects.
     */
    @GetMapping("/department")
    public List<DepartmentDto> getAllDepartments() {
       return departmentService.getAllDepartments();
    }

    /**
     * <p>
     * Updates an existing department's details.
     * </p>
     * @param id The ID of the department to update.
     * @return The updated DepartmentDto object.
     */
    @PutMapping("/department/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable("id") int id) {
        return departmentService.updateDepartment((departmentDto), id);
    }

    /**
     * <p>
     * Removes a department by setting its active status to false.
     * </p>
     *
     * @param id The ID of the department to remove.
     */
    @DeleteMapping("/department/{id}")
    public String deleteDepartment (@PathVariable("id") int id) {
        departmentService.deleteDepartment(id);
        return "Department Deleted Successfully";
    }

    /**
     * <p>
     * Retrieves a department by its ID.
     * </p>
     *
     * @param id The ID of the department to retrieve.
     * @return The DepartmentDto object of the retrieved department.
     */
    @GetMapping("/department/{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") int id) {
        return departmentService.getDepartmentById(id);
    }
}
