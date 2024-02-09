package it.epicode.w5d5.repository;

import it.epicode.w5d5.Edificio;
import it.epicode.w5d5.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {


//    @Query("select x from Drink x where x.nome = :nome")
//    public List<Postazione> findByNome(String nome);
//
//    @Query("select x from Drink x")
//    public List<Postazione> findAll();

}
