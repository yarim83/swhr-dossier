package pl.sw.gov.persondossier.employees.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
