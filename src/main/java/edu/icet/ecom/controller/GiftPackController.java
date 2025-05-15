package edu.icet.ecom.controller;

import edu.icet.ecom.dto.GiftPack;
import edu.icet.ecom.service.GiftPackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/giftPack")
@CrossOrigin
public class GiftPackController {
    private final GiftPackService giftPackService;

    @PostMapping("/add")
    public ResponseEntity<GiftPack> add(@Valid @RequestBody GiftPack giftPack) {
        System.out.println(giftPack);
        return ResponseEntity.of(giftPackService.add(giftPack)) ;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("giftPackId")  Long giftPackId) {
        giftPackService.delete(giftPackId);
    }

    @PutMapping("/update")
    public void update(@RequestBody GiftPack giftPack) {
        giftPackService.update(giftPack);
    }

    @GetMapping("/get-all")
    public List<GiftPack> getAll() {
        return giftPackService.getAll();
    }

    @GetMapping("/search-by-name")
    public  List<GiftPack>  searchByName(@RequestParam("name") String name) {
        return giftPackService.searchByName(name);
    }
}
