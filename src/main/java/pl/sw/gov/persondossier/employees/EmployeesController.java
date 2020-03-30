package pl.sw.gov.persondossier.employees;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.department.DepartmentRepository;
import pl.sw.gov.persondossier.dto.EmployeeDetailsDto;
import pl.sw.gov.persondossier.dto.EmployeesDto;
import pl.sw.gov.persondossier.model.Department;
import pl.sw.gov.persondossier.model.Employees;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeesController {

    private final EmployeesRepository employeesRepository;

    private final DepartmentRepository departmentRepository;

    private final EmployeesRepositoryPaging employeesRepositoryPaging;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Employees> getAll() {
        return employeesRepository.findAll();
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Page<Employees> getAllPage(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable2 = PageRequest.of(page, 10);
        return employeesRepositoryPaging.findAll(pageable2);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDetailsDto getById(@PathVariable long id) {
        EmployeeDetailsDto employeeDetailsDto = convertToDetailsDto(employeesRepository.findById(id).get());
        return employeeDetailsDto;
    }

    @GetMapping("/find")
    public Set<Employees> findByLastNameAndSort(@RequestParam("lastName") String lastName) {
        return employeesRepository.findByLastName(lastName);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid EmployeesDto employeesDto) {
        Employees employees = convertToEntity(employeesDto);
        employeesRepository.save(employees);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid Employees employees) {
        employeesRepository.save(employees);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        employeesRepository.delete(employeesRepository.getOne(id));
    }

    private EmployeeDetailsDto convertToDetailsDto(Employees employees) {
        EmployeeDetailsDto employeeDetailsDto = new EmployeeDetailsDto();
        BeanUtils.copyProperties(employees, employeeDetailsDto,
                "permissionLevel",
                "createdDate");
        return employeeDetailsDto;
    }

    private Employees convertToEntity(EmployeesDto employeesDto) {
        System.out.println(employeesDto.toString());
        Employees employees = new Employees();

        if (employeesDto.getDepartment_id() != null) {
            Department department = departmentRepository.findById(employeesDto.getDepartment_id()).get();
            BeanUtils.copyProperties(employeesDto, employees, "department_id");
            employees.setDepartment(department);
        }
        System.out.println(employees);
        return employees;
    }

}
