package pl.sw.gov.persondossier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.sw.gov.persondossier.employees.photo.PhotoRepository;
import pl.sw.gov.persondossier.model.Photo;

public class PhotoConverter implements Converter<String, Photo> {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo convert(String s){
        return photoRepository.findById(Long.parseLong(s)).orElseThrow(IllegalAccessError::new);
    }

}
