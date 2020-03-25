package pl.sw.gov.persondossier.department;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.sw.gov.persondossier.model.Department;

public interface DepartmentRepositoryPaging extends PagingAndSortingRepository<Department, Integer> {
}
