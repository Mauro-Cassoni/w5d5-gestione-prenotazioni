package it.epicode.w5d5.service;

import it.epicode.w5d5.Prenotazione;
import it.epicode.w5d5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione){
        prenotazioneRepository.save(prenotazione);
    }
    
    public void aggiornaPrenotazione(Prenotazione prenotazione){
        Prenotazione x = prenotazioneRepository.findById(prenotazione.getId()).get();
        x.setUtente(prenotazione.getUtente());
        x.setPostazione(prenotazione.getPostazione());
        prenotazioneRepository.save(prenotazione);
    }
    
    public Prenotazione cercaById(int id){
        return prenotazioneRepository.findById(id).get();
    }
    
    public void cancellaPrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }

//    public List<Prenotazione> cercaPizzaPerNome(String nome){
//        return prenotazioneRepository.findByNome(nome);
//    }
//
//    public List<Prenotazione> mostraTutteLePizze(){
//        return prenotazioneRepository.findAll();
//    }
//
    
    
    
    
}
