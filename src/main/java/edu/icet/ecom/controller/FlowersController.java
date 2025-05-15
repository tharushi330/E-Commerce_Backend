package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Flowers;
import edu.icet.ecom.service.FlowersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flowers")
@CrossOrigin
public class FlowersController {
    private final FlowersService flowersService;

    @PostMapping("/add")
    public ResponseEntity<Flowers> add(@Valid @RequestBody Flowers flowers) {
        System.out.println(flowers);
        return ResponseEntity.of(flowersService.add(flowers)) ;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("flowerId")  Long flowerId) {
        flowersService.delete(flowerId);
    }

    @PutMapping("/update")
    public void update(@RequestBody Flowers flowers) {
        flowersService.update(flowers);
    }

    @GetMapping("/get-all")
    public List<Flowers> getAll() {
        return flowersService.getAll();
    }

    @GetMapping("/search-by-name")
    public  List<Flowers>  searchByName(@RequestParam("name") String name) {
        return flowersService.searchByName(name);
    }
}
