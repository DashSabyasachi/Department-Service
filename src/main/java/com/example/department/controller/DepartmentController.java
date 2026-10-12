package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> create(@Valid @RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(department));
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @Valid @RequestBody Department department) {
        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
