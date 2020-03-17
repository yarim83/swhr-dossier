package pl.sw.gov.persondossier.employees;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.sw.gov.persondossier.model.Employees;

public interface EmployeesRepositoryPaging extends PagingAndSortingRepository<Employees, Integer> {

}
