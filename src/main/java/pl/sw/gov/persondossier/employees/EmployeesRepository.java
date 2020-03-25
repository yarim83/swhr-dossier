package pl.sw.gov.persondossier.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Employees;

import java.util.Set;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    public Set<Employees> findByLastName( String lastName);
}
