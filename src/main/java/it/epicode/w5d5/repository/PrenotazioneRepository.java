package it.epicode.w5d5.repository;

import it.epicode.w5d5.Edificio;
import it.epicode.w5d5.Postazione;
import it.epicode.w5d5.Prenotazione;
import it.epicode.w5d5.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.postazione = ?1 and p.dataPrenotazione = ?2")
    boolean verPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    @Query("SELECT COUNT(p) > 0 FROM Prenotazione p WHERE p.utente = :utente and p.dataPrenotazione = :dataPrenotazione")
    boolean verUtente(Utente utente, LocalDate dataPrenotazione);



}
