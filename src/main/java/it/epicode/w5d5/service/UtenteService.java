package it.epicode.w5d5.service;

import it.epicode.w5d5.Utente;
import it.epicode.w5d5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente){
        utenteRepository.save(utente);
    }
    
    public void aggiornaUtente(Utente utente){
        Utente x = utenteRepository.findById(utente.getId()).get();
        x.setPrenotazioni(utente.getPrenotazioni());
        x.setNome(utente.getNome());
        x.setCognome(utente.getCognome());
        x.setUsername(utente.getUsername());
        x.setEmail(utente.getEmail());
        utenteRepository.save(utente);
    }
    
    public Utente cercaById(int id){
        return utenteRepository.findById(id).get();
    }
    
    public void cancellaUtente(int id){
        utenteRepository.deleteById(id);
    }

//    public List<Utente> cercaPizzaPerNome(String nome){
//        return utenteRepository.findByNome(nome);
//    }
//
//    public List<Utente> mostraTutteLePizze(){
//        return utenteRepository.findAll();
//    }
//
    
    
    
    
}
