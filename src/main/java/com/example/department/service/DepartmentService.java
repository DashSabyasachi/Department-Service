package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.exception.ResourceNotFoundException;
import com.example.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department create(Department department) {
        return repository.save(department);
    }

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));
    }

    public Department update(Long id, Department updated) {
        Department existing = getById(id);
        existing.setName(updated.getName());
        existing.setLocation(updated.getLocation());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
