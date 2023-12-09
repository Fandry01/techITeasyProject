package nl.novi.easytech.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionsController {
    @GetMapping(value = "/televisions")
    public ResponseEntity<Object> getAllTelevisions(){
        return ResponseEntity.ok("television");
    }
    @GetMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable("id") int id){
        return ResponseEntity.ok("television with id: " + id);

    }
    @PostMapping(value = "/televisions")
    public ResponseEntity<String> addTelevision(@RequestBody String television){
        return  ResponseEntity.created(null).body(television);
    }
    @DeleteMapping(value = "/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/televisions")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String Television){
        return ResponseEntity.noContent().build();
    }
}
