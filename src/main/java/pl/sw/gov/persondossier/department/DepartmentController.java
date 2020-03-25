package pl.sw.gov.persondossier.department;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.Department;
import pl.sw.gov.persondossier.model.Employees;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentRepositoryPaging departmentRepositoryPaging;

    @GetMapping("/")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("/list")
    public Page<Department> getAllPage(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,10);
        return departmentRepositoryPaging.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable long id) {
        return departmentRepository.findById(id).get();
    }

    @PostMapping("/")
    public void add(@RequestBody @Valid Department department) {
        departmentRepository.save(department);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Department department) {
        departmentRepository.save(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        departmentRepository.delete(departmentRepository.getOne(id));
    }
}
