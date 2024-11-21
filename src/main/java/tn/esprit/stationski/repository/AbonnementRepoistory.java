package tn.esprit.stationski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationski.entities.Abonnement;
import tn.esprit.stationski.entities.Piste;

import java.util.List;

@Repository
public interface AbonnementRepoistory extends JpaRepository<Abonnement,Long> {



}
