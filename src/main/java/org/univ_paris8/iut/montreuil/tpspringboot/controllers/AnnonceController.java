package org.univ_paris8.iut.montreuil.tpspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.univ_paris8.iut.montreuil.tpspringboot.entities.Annonce;
import org.univ_paris8.iut.montreuil.tpspringboot.services.AnnonceService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("annonce")
public class AnnonceController {

    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> getAnnonces() {
        List<Annonce> annonces = annonceService.getAllAnnonces();

        if (annonces.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable int id) {
        Optional<Annonce> annonce = annonceService.getAnnonceById(id);

        return annonce.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        Annonce savedAnnonce = annonceService.saveAnnonce(annonce);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnnonce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnnonce(@PathVariable int id, @RequestBody Annonce annonce) {
        try {
            Annonce updatedAnnonce = annonceService.updateAnnonce(id, annonce);
            return ResponseEntity.ok(updatedAnnonce);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteAnnonce(@PathVariable int id) {
        try {
            annonceService.deleteAnnonceById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
