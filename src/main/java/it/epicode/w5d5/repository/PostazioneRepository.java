package it.epicode.w5d5.repository;

import it.epicode.w5d5.Edificio;
import it.epicode.w5d5.Postazione;
import it.epicode.w5d5.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    @Query("select p from Postazione p where p.tipo = :tipoPostazione and p.edificio.citta = :citta")
    List<Postazione> cercaPerTipoECitta(Tipo tipoPostazione, String citta);

}
