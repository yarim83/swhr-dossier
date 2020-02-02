package pl.sw.gov.persondossier.permistionlevel;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.PermissionLevel;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/permission-level")
public class PermissionLevelController {

    private final PermissionLevelRepository permissionLevelRepository;

    @GetMapping("/")
    public ResponseEntity<Collection<PermissionLevel>> getAll(){
        Collection<PermissionLevel> allPermissionLevels = permissionLevelRepository.findAll();
        if (allPermissionLevels.isEmpty()) {
            return new ResponseEntity<Collection<PermissionLevel>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<PermissionLevel>>(allPermissionLevels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionLevel> getById(@PathVariable("id") long id) {
        Optional<PermissionLevel> permissionLevel = permissionLevelRepository.findById(id);
        if (!permissionLevel.isPresent()){
            return new ResponseEntity<PermissionLevel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PermissionLevel>(permissionLevel.get(), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/")
    public void add(@RequestBody @Valid PermissionLevel permissionLevel, BindingResult bindingResult) {
        permissionLevelRepository.save(permissionLevel);
    }

    @PutMapping("{id}")
    public void update(@RequestBody PermissionLevel permissionLevel) {
        permissionLevelRepository.save(permissionLevel);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        PermissionLevel permissionLevel = permissionLevelRepository.getOne(id);
        if (permissionLevel == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        permissionLevelRepository.delete(permissionLevel);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
