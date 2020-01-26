package pl.sw.gov.persondossier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sw.gov.persondossier.model.Employees;
import pl.sw.gov.persondossier.model.PermissionLevel;
import pl.sw.gov.persondossier.repository.EmployeesRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeesController {
    private final EmployeesRepository employeesRepository;


    @GetMapping("/")
    public List<Employees> getAll() {
        return employeesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employees getById(@PathVariable long id) {
        return employeesRepository.findById(id).get();
    }


    public void add() {

    }


    public void update() {

    }

    public void delete() {

    }
}
