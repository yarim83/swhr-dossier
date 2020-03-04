package pl.sw.gov.persondossier.permistionlevel;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sw.gov.persondossier.model.PermissionLevel;

public interface PermissionLevelRepository extends JpaRepository<PermissionLevel,Long> {
}
