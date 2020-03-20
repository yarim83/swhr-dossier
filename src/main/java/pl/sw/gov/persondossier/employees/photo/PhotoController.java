package pl.sw.gov.persondossier.employees.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sw.gov.persondossier.model.Photo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/photo")
public class PhotoController {

    private final PhotoRepository photoRepository;

    @PostMapping("/upload")
    public ResponseEntity<Photo> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original photo Byte Size = " + file.getBytes().length);
        Photo photo = new Photo(file.getOriginalFilename(), file.getContentType(), compressByte(file.getBytes()));

        photoRepository.save(photo);

        return new ResponseEntity<Photo>(photo,HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Photo> getAll() {
        return photoRepository.findAll();
    }

    // TEST
//    @GetMapping("/{id}")
//    public Photo getById(@PathVariable long id){
//        return photoRepository.findById(id).get();
//    }

//    @GetMapping(path = {"/{imageName}"})
//    public Photo getPhoto(@PathVariable("imageName") String imageName) throws IOException{
//        final Optional<Photo> retriveImage = photoRepository.findByName(imageName);
//        Photo photo = new Photo(retriveImage.get().getName(), retriveImage.get().getType(),decompressByte(retriveImage.get().getPicByte()));
//        return photo;
//    }


    @GetMapping(path = {"/{id}"})
    public Photo getPhoto(@PathVariable long id) throws IOException{
        final Optional<Photo> retriveImage = photoRepository.findById(id);
        Photo photo = new Photo(retriveImage.get().getName(), retriveImage.get().getType(),decompressByte(retriveImage.get().getPicByte()));
        return photo;
    }

    //before save - compressing img byte
    public static byte[] compressByte(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }

        System.out.println("Wielkość kompresji :" + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    //before return - decompress img
    public static byte[] decompressByte(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
