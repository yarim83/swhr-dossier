package pl.sw.gov.persondossier.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
