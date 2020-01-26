package pl.sw.gov.persondossier.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.PermissionLevel;
import pl.sw.gov.persondossier.repository.PermissionLevelRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/permission-level")
public class PermissionLevelController {

    private final PermissionLevelRepository permissionLevelRepository;

    @GetMapping("/")
    public List<PermissionLevel> getAll() {
        return permissionLevelRepository.findAll();
    }

    @GetMapping("/{id}")
    public PermissionLevel getById(@PathVariable long id) {
        return permissionLevelRepository.findById(id).get();
    }


    public void add() {

    }


    public void update() {

    }


    public void delete() {

    }
}
