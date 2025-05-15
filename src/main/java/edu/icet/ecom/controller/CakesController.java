package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Cakes;
import edu.icet.ecom.service.CakesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cakes")
@CrossOrigin
public class CakesController {
    private final CakesService cakesService;

    @PostMapping("/add")
    public ResponseEntity<Cakes> add(@Valid @RequestBody Cakes cakes) {
        System.out.println(cakes);
        return ResponseEntity.of(cakesService.add(cakes)) ;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id")  Long id) {
        cakesService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Cakes cakes) {
        cakesService.update(cakes);
    }

    @GetMapping("/get-all")
    public List<Cakes> getAll() {
        return cakesService.getAll();
    }

    @GetMapping("/search-by-name")
    public  List<Cakes>  searchByName(@RequestParam("name") String name) {
        return cakesService.searchByName(name);
    }

}
