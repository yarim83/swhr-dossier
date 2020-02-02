package pl.sw.gov.persondossier.employees.adress;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.Address;

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

    @PostMapping("/")
    public void add(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        addressRepository.delete(addressRepository.getOne(id));
    }
}
