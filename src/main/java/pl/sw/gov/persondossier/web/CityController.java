package pl.sw.gov.persondossier.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.domain.City;
import pl.sw.gov.persondossier.repository.CityRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping("/")
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable long id){
        return cityRepository.findById(id).get();
    }

}
