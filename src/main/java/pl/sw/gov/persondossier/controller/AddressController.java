package pl.sw.gov.persondossier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.Address;
import pl.sw.gov.persondossier.model.PermissionLevel;
import pl.sw.gov.persondossier.repository.AddressRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping("/")
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable long id) {
        return addressRepository.findById(id).get();
    }


    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
