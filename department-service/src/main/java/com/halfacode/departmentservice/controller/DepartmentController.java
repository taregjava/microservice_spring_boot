package com.halfacode.departmentservice.controller;

import com.halfacode.departmentservice.entity.Department;
import com.halfacode.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long id){
        return departmentService.findDepartmentById(id);
    }

}
