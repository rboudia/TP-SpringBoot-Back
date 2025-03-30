package org.univ_paris8.iut.montreuil.tpspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.univ_paris8.iut.montreuil.tpspringboot.entities.Annonce;
import org.univ_paris8.iut.montreuil.tpspringboot.repositories.AnnonceRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    public Optional<Annonce> getAnnonceById(Integer id) {
        return annonceRepository.findById(id);
    }

    public Annonce saveAnnonce(Annonce annonce) {
        annonce.setDate(Timestamp.valueOf(LocalDateTime.now()));
        return annonceRepository.save(annonce);
    }

    public Annonce updateAnnonce(int id, Annonce annonceDetails) {
        Optional<Annonce> optionalAnnonce = annonceRepository.findById(id);

        if (optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            annonce.setTitle(annonceDetails.getTitle());
            annonce.setDescription(annonceDetails.getDescription());
            annonce.setAdress(annonceDetails.getAdress());
            annonce.setMail(annonceDetails.getMail());
            annonce.setDate(Timestamp.valueOf(LocalDateTime.now()));

            return annonceRepository.save(annonce);
        } else {
            throw new RuntimeException("Annonce non trouvée avec l'id : " + id);
        }
    }


    public void deleteAnnonceById(int id) {
        Optional<Annonce> optionalAnnonce = annonceRepository.findById(id);

        if (optionalAnnonce.isPresent()) {
            annonceRepository.delete(optionalAnnonce.get());
        } else {
            throw new RuntimeException("Annonce non trouvée avec l'id : " + id);
        }
    }

}
