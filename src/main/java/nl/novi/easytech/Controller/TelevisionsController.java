package nl.novi.easytech.Controller;

import nl.novi.easytech.Models.Television;
import nl.novi.easytech.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {
    @Autowired
    private TelevisionRepository televisionRepo;
    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return ResponseEntity.ok(televisionRepo.findAll());


    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable("id") int id){
        Optional<Television> findTelevision = televisionRepo.findById(id);
        return ResponseEntity.ok(findTelevision.get());

    }
    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television){
       Television SavedTelevision = televisionRepo.save(television);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + television.getId()).toUriString());
        return  ResponseEntity.created(uri).body(SavedTelevision);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id){
        televisionRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/televisions")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String Television){

        return ResponseEntity.noContent().build();
    }
}
