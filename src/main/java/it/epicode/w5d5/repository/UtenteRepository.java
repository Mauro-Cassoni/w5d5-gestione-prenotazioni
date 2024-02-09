package it.epicode.w5d5.repository;

import it.epicode.w5d5.Edificio;
import it.epicode.w5d5.Prenotazione;
import it.epicode.w5d5.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {



}
