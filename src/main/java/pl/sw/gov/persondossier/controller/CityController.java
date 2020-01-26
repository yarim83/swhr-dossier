package pl.sw.gov.persondossier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sw.gov.persondossier.model.City;
import pl.sw.gov.persondossier.repository.CityRepository;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping("/")
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable long id){
        return cityRepository.findById(id).get();
    }

    @PostMapping("/")
    public void add(@RequestBody City city){
        cityRepository.save(city);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody City city){
        cityRepository.save(cityRepository.findById(city.getId()).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody long id){
        cityRepository.delete(cityRepository.getOne(id));
    }

}
