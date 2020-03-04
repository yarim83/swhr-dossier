package pl.sw.gov.persondossier.employees.adress;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
