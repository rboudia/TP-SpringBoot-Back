package org.univ_paris8.iut.montreuil.tpspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.univ_paris8.iut.montreuil.tpspringboot.entities.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}
