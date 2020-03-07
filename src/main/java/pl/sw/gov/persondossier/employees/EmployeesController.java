package pl.sw.gov.persondossier.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.employees.adress.EmployeesRepositoryPaging;
import pl.sw.gov.persondossier.model.Employees;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeesController {
    private final EmployeesRepository employeesRepository;
    private final EmployeesRepositoryPaging employeesRepositoryPaging;

    @GetMapping("/")
    public List<Employees> getAll() {
        return employeesRepository.findAll();
    }

    @GetMapping("/list")
    public Page<Employees> getAllPage(@RequestParam(defaultValue = "0") int page) {
        Pageable test = PageRequest.of(page,10);
        return employeesRepositoryPaging.findAll(test);
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
        employeesRepository.save(employees);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        employeesRepository.delete(employeesRepository.getOne(id));
    }
}
