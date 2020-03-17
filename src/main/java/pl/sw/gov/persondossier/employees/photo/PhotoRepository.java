package pl.sw.gov.persondossier.employees.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Photo;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Optional<Photo> findByName(String name);
}
