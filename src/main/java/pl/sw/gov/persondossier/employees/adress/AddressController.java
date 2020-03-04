package pl.sw.gov.persondossier.employees.adress;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.Address;

import javax.validation.Valid;
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
    public ResponseEntity<Address> add(@RequestBody @Valid Address address, BindingResult bindingResult) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (bindingResult.hasErrors() || address == null){
            httpHeaders.add("errors", "cant add entity");
            return new ResponseEntity<Address>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        addressRepository.save(address);
        return new ResponseEntity<Address>(address,HttpStatus.CREATED);
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
