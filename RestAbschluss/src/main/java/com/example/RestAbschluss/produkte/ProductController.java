package com.example.RestAbschluss.produkte;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/produkte")
public class ProductController {

    @Autowired
    ProduktReposetory produktReposetory;


    @PostMapping("")
    public void createProdukt(@RequestBody Produkt produkt){

        produktReposetory.save(produkt);
    }

    @GetMapping("/{productId}")
    public Produkt readProdukt(@PathVariable Long productId){

        Optional<Produkt> produkt=produktReposetory.findById(productId);
        if (produkt.isPresent()){
            return produkt.get();
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"produkt nicht gefunden");
    }

    @PutMapping("/{produktId}")
    public void updateProduct(@PathVariable Long produktId,@RequestBody Produkt produktUpdate){
Optional<Produkt> produkt=produktReposetory.findById(produktId);
if(!produkt.isPresent()){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produkt liegt nicht vor");
}
Produkt produktInstanse=produkt.get();
produktInstanse.setName(produktUpdate.getName());
produktInstanse.setKosten(produktUpdate.getKosten());
produktReposetory.save(produktInstanse);

    }


    @DeleteMapping ("/{productId}")
    public void deleteProduct(@PathVariable Long productId){

        Optional<Produkt> produkt=produktReposetory.findById(productId);
        if (produkt.isPresent()){
            produktReposetory.deleteById(productId);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"produkt nicht gefunden");
    }



}
