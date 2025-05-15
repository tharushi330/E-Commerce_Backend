package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Toys;
import edu.icet.ecom.service.ToysService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/toys")
@CrossOrigin
public class ToysController {
    private final ToysService toysService;

    @PostMapping("/add")
    public ResponseEntity<Toys> add(@Valid @RequestBody Toys toys) {
        System.out.println(toys);
        return ResponseEntity.of(toysService.add(toys)) ;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("toyId")  Long toyId) {
        toysService.delete(toyId);
    }

    @PutMapping("/update")
    public void update(@RequestBody Toys toys) {
        toysService.update(toys);
    }

    @GetMapping("/get-all")
    public List<Toys> getAll() {
        return toysService.getAll();
    }

    @GetMapping("/search-by-name")
    public  List<Toys>  searchByName(@RequestParam("name") String name) {
        return toysService.searchByName(name);
    }
}
