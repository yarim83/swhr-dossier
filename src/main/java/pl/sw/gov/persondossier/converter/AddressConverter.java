package pl.sw.gov.persondossier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.sw.gov.persondossier.model.Address;
import pl.sw.gov.persondossier.repository.AddressRepository;

public class AddressConverter implements Converter<String, Address> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address convert(String s){
        return addressRepository.findById(Long.parseLong(s)).orElseThrow(IllegalArgumentException::new);
    }
}
