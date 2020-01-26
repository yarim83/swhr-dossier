package pl.sw.gov.persondossier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
