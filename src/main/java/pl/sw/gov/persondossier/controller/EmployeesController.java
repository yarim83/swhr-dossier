package pl.sw.gov.persondossier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/")
    public void add(@RequestBody Employees employees) {
        employeesRepository.save(employees);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Employees employees) {
        employeesRepository.save(employeesRepository.findById(employees.getId()).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody long id) {
        employeesRepository.delete(employeesRepository.getOne(id));
    }
}
