package pl.sw.gov.persondossier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.Department;
import pl.sw.gov.persondossier.model.PermissionLevel;
import pl.sw.gov.persondossier.repository.DepartmentRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @GetMapping("/")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable long id) {
        return departmentRepository.findById(id).get();
    }


    public void add() {

    }


    public void update() {

    }


    public void delete() {

    }
}
