package pl.sw.gov.persondossier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.domain.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
